package com.dev.backend.api;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.dev.backend.model.Book;
import com.dev.backend.repository.BookRepository;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class BookController extends UserController{
  public static String uploadDirectory= System.getProperty("user.dir") +"/backend/src/main/resources/static/images"; 
  private AmazonS3 s3Client;
  @Value("${s3.endpointUrl}")
  private String endpointUrl;
  @Value("${s3.accessKey}")
  private String accessKey;
  @Value("${s3.secertKey}")
  private String secretKey;
  @Value("${s3.bucketName}")
  private String bucketName;
  
 
  @Autowired
    private BookRepository bookRepository;
    
    
    public String viewHomePage(Model model)
    {
     List<Book> listBooks=(List<Book>)bookRepository.findAll();
      
      model.addAttribute("listBook", listBooks);
     
     return "Book_main";
    }
    
    @RequestMapping("/addNewBook")
    public String showNewBookFrom(Model model){
      Book book=new Book();
      
      model.addAttribute("book", book);
      return "Book_Register";
    }

    @PostConstruct
    private void initializeAmazom(){
      AWSCredentials credentials=new BasicAWSCredentials(this.accessKey, this.secretKey);
      this.s3Client = new AmazonS3Client(credentials);
    }
    @RequestMapping(value = "/save",method=RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book, @RequestParam("file") MultipartFile file) throws IOException 
    {   
      String fileUrl="";
      try{
        String fileName=file.getOriginalFilename();
        File convFile=new File(fileName);
        FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, convFile) .withCannedAcl(CannedAccessControlList.PublicRead));
       
        // String filePath=Paths.get(uploadDirectory, fileName).toString();
        // BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
        //   stream.write(file.getBytes());
        //   stream.close();
 
          book.setImg_name(fileName);
          bookRepository.save(book);
          convFile.delete();
        }
        catch(AmazonServiceException are){
       
        }
        
        
        return "redirect:/main/book";
    }

    
    @RequestMapping("/editBook/{id}")
    public ModelAndView showEditBookFrom(@PathVariable(name="id") int id){
      ModelAndView mav=new ModelAndView("Book_edit");
      Book book= bookRepository.findById(id).get();
      mav.addObject("book", book);
      return mav;
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(name="id") int id) {
      Optional<Book> book=bookRepository.findById(id);
      String imgName=book.get().getImg_name();
      System.out.println(imgName);
 
      s3Client.deleteObject(new DeleteObjectRequest(bucketName,imgName));
   
    
      bookRepository.deleteById(id);

      return "redirect:/main/book";
    }
    @RequestMapping("/searchByBook")
    public ModelAndView searchByBook(@RequestParam String keyword){
      ModelAndView mav= new ModelAndView("Book_search");
      List<Book> result=bookRepository.searchByBook(keyword);
      mav.addObject("result", result);
      return mav;
    }
    @RequestMapping("/searchByIsbn")
    public ModelAndView searchByIsbn(@RequestParam String keyword){
      ModelAndView mav= new ModelAndView("Book_search");
      List<Book> result=bookRepository.searchByIsbn(keyword);
      mav.addObject("result", result);
      return mav;
    }
    @RequestMapping("/searchByTitle")
    public ModelAndView searchByTitle(@RequestParam String keyword){
      ModelAndView mav= new ModelAndView("Book_search");
      List<Book> result=bookRepository.searchByTitle(keyword);
      mav.addObject("result", result);
      return mav;
    }
    @RequestMapping("/searchByCategory")
    public ModelAndView searchByCategory(@RequestParam String keyword){
      ModelAndView mav= new ModelAndView("Book_search");
      List<Book> result=bookRepository.searchByCategory(keyword);
      mav.addObject("result", result);
      return mav;
    }
    @RequestMapping("/searchByAuthor")
    public ModelAndView searchByAuthor(@RequestParam String keyword){
      ModelAndView mav= new ModelAndView("Book_search");
      List<Book> result=bookRepository.searchByAuthor(keyword);
      mav.addObject("result", result);
      return mav;
    }
    @RequestMapping("/toMain")
    public String toMain(){
    
      return "redirect:/main/mainpage";
  }

}


package com.dev.backend.api;
import com.dev.backend.model.Book;
import com.dev.backend.dao.BookDao;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class BookController extends UserController{
  public static String uploadDirectory= System.getProperty("user.dir") +"/backend/src/main/resources/static/images"; 
    @Autowired
    private BookDao dao;
    
    
    public String viewHomePage(Model model)
    {
     List<Book> listBooks=(List<Book>)dao.findAll();
      
      model.addAttribute("listBook", listBooks);
     
     return "book_main";
    }
    @RequestMapping("/new")
    public String showNewBookFrom(Model model){
      Book book=new Book();
      
      model.addAttribute("book", book);
      return "book_new";
    }

    @RequestMapping(value = "/save",method=RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book, @RequestParam("file") MultipartFile file) 
    {   
      try{
        String fileName=file.getOriginalFilename();
        String filePath=Paths.get(uploadDirectory, fileName).toString();
        System.out.println(filePath);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
        
          stream.write(file.getBytes());
          stream.close();
 
          book.setImg_name(fileName);
          dao.save(book);
        }
        catch(Exception e){
          return "redirect:/main/book";

        }
        
       
        
        return "redirect:/main/book";
    }
    /*
    @PostMapping("/file/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file ){
      System.out.println(file.getOriginalFilename()
    return "fileupload";
    }
    */
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBookFrom(@PathVariable(name="id") int id){
      ModelAndView mav=new ModelAndView("book_edit");
      Book book= dao.findById(id).get();
      mav.addObject("book", book);
      return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name="id") int id){
      dao.deleteById(id);
      return "redirect:/main/book";
    }
    @RequestMapping("/searchByBook")
    public ModelAndView searchByBook(@RequestParam String keyword){
      ModelAndView mav= new ModelAndView("book_search");
      List<Book> result=dao.searchByBook(keyword);
      mav.addObject("result", result);
      return mav;
    }
    @RequestMapping("/searchByIsbn")
    public ModelAndView searchByIsbn(@RequestParam String keyword){
      ModelAndView mav= new ModelAndView("book_search");
      List<Book> result=dao.searchByIsbn(keyword);
      mav.addObject("result", result);
      return mav;
    }
    @RequestMapping("/searchByTitle")
    public ModelAndView searchByTitle(@RequestParam String keyword){
      ModelAndView mav= new ModelAndView("book_search");
      List<Book> result=dao.searchByTitle(keyword);
      mav.addObject("result", result);
      return mav;
    }
    @RequestMapping("/searchByCategory")
    public ModelAndView searchByCategory(@RequestParam String keyword){
      ModelAndView mav= new ModelAndView("book_search");
      List<Book> result=dao.searchByCategory(keyword);
      mav.addObject("result", result);
      return mav;
    }
    @RequestMapping("/searchByAuthor")
    public ModelAndView searchByAuthor(@RequestParam String keyword){
      ModelAndView mav= new ModelAndView("book_search");
      List<Book> result=dao.searchByAuthor(keyword);
      mav.addObject("result", result);
      return mav;
    }
    @RequestMapping("/toMain")
    public String toMain(){
    
      return "redirect:/main/mainpage";
  }

}


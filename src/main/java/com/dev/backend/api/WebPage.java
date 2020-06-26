package com.dev.backend.api;

import com.dev.backend.model.Book;
import com.dev.backend.dao.BookDao;
import com.dev.backend.dao.CustomerDao;
import com.dev.backend.dao.UserRepository;
import com.dev.backend.model.Customer;
import com.dev.backend.model.User;
import com.dev.backend.service.UserServiceImp;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

//user web page 
@Controller
@RequestMapping("/webHome")
public class WebPage {

  @Autowired
    private BookDao dao;
  @Autowired
    private UserRepository user;
  @Autowired
    private UserServiceImp userService;
    @RequestMapping("/webMain" )
    public String viewWebPage(Map<String, Object> model)
    {
     List<String> listImg=(List<String>) dao.getImg();
     List<String> listTitle=(List<String>) dao.getTitle();
     model.put("listImg", listImg);
     model.put("listTitle", listTitle);
     return "web_main";
    }
    
  @RequestMapping("/newC_web" )
    public String showNewUserFromWeb(Model model){
      User customer=new User();
      model.addAttribute("user", customer);
      return "customer_new";
    }
  //@RequestMapping("/search")
  public ModelAndView search(@RequestParam String keyword){
    ModelAndView mav= new ModelAndView("book_search");
    List<Book> result=dao.searchByBook(keyword);
    mav.addObject("result", result);
    return mav;
  }
    // @RequestMapping( value="{img_name}", method = RequestMethod.GET)
    // public ModelAndView newPage(@PathVariable(name="img_name") String img_name, Authentication authentication ){
    //   System.out.println(authentication.getName());
    //   ModelAndView mav=new ModelAndView("web_bookPage");
    //   List<Book> result=dao.searchByImage(img_name);
    //   mav.addObject("listBook", result);
    //   return mav;
    // }
    
    @RequestMapping("{img_name}")
    public String newPage(@PathVariable(name="img_name") String img_name, Map<String, Object> model ){
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      Book result=dao.searchByImage(img_name);
      model.put("listBook", result);
      model.put("user_name", auth.getName());
      return "web_bookPage";
    }
    @RequestMapping("/cart/{book_id}")
    public String passBookToCart(@PathVariable(name="book_id") String book_id){
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      
      Optional<Book> result=dao.findById(Integer.parseInt(book_id));
      User searchedUser=user.findByEmail(auth.getName());
      userService.saveAtCart(searchedUser,result.get());
      return "redirect:/webHome/webMain";
    }
  

    // @RequestMapping("/cart/{user_id}")
    // public ModelAndView showNewUserFrom(@PathVariable(name="user_id") String user_id){
    //   ModelAndView mav=new ModelAndView("customer_cart");
    //   Optional<Book> result=dao.findById(Integer.parseInt(user_id));
    //   System.out.println(result.get());
    //   mav.addObject("listBook", result.get());
  
    //   return mav;
    // }
  
     
    @RequestMapping("/toWebMain")
    public String toMain(){
    
      return "redirect:/webHome/webMain";
  }
  
    
}
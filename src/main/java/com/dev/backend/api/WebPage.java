package com.dev.backend.api;

import com.dev.backend.model.Book;
import com.dev.backend.dao.BookDao;
import com.dev.backend.dao.CustomerDao;
import com.dev.backend.model.Customer;
import com.dev.backend.model.User;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

//user web page 
@Controller
@RequestMapping("/webHome")
public class WebPage {

  @Autowired
    private BookDao dao;
   
    @RequestMapping("/webMain")
    public String viewWebPage(Map<String, Object> model)
    {
     List<String> listimge=(List<String>) dao.getImg();
      
      model.put("listBook", listimge);
     
    return "web_main";
    }
    
  @RequestMapping("/newC_web")
    public String showNewUserFromWeb(Model model){
      User customer=new User();
      model.addAttribute("user", customer);
      return "customer_new";
    }
  //@RequestMapping("/search")
  public ModelAndView search(@RequestParam String keyword){
    ModelAndView mav= new ModelAndView("book_search");
    List<Book> result=dao.search(keyword);
    mav.addObject("result", result);
    return mav;
  }
    @RequestMapping("{img_name}")
    public ModelAndView newPage(@PathVariable(name="img_name") String img_name){
      ModelAndView mav=new ModelAndView("web_bookPage");
      List<Book> result=dao.searchByImage(img_name);
      mav.addObject("listBook", result);
      return mav;
    }
    
    @RequestMapping("/newWeb")
    public String showNewUserFrom(Model model){
      Customer customer=new Customer();
      model.addAttribute("customer", customer);
      return "web_new_account";
    }
  
     
    @RequestMapping("/toWebMain")
    public String toMain(){
    
      return "redirect:/webHome/webMain";
  }
  
    
}
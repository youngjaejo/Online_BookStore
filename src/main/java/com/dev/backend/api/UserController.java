package com.dev.backend.api;
import com.dev.backend.model.User;
import com.dev.backend.service.UserService;
import com.dev.backend.dao.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public abstract class UserController{
    @Autowired
    private UserRepository dao;
    @Autowired
    private UserService userService;
   
    public String viewCustomPage(Model model)
    {
      List<User> listUsers=(List<User>)dao.findAll();
      System.out.println(listUsers.size());
      model.addAttribute("listUsers", listUsers);
      return "user_main";
    }
    @RequestMapping("/newC")
    public String showNewUserFrom(Model model){
      User customer=new User();
      model.addAttribute("user", customer);
      return "customer_new";
    }
    @RequestMapping("/newU_admin")
    public String showNewAdminUserFrom(Model model){
      User customer=new User();
      model.addAttribute("user", customer);
      return "customer_new_admin";
    }
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
      ModelAndView modelAndView = new ModelAndView();
      // Check for the validations
      if(bindingResult.hasErrors()) {
        modelAndView.addObject("successMessage", "Please correct the errors in form!");
        modelMap.addAttribute("bindingResult", bindingResult);
      }
      else if(userService.isUserAlreadyPresent(user)){
        modelAndView.addObject("successMessage", "user already exists!");			
      }
  
      else {
        userService.saveUser(user);
        modelAndView.addObject("successMessage", "User is registered successfully!");
       
      }
      modelAndView.addObject("user", new User());
      modelAndView.setViewName("customer_new");
      return modelAndView;
    }

    @RequestMapping(value="/register_admin", method=RequestMethod.POST)
    public ModelAndView registerAdminUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
      ModelAndView modelAndView = new ModelAndView();
      // Check for the validations
      if(bindingResult.hasErrors()) {
        modelAndView.addObject("successMessage", "Please correct the errors in form!");
        modelMap.addAttribute("bindingResult", bindingResult);
      }
      else if(userService.isUserAlreadyPresent(user)){
        modelAndView.addObject("successMessage", "user already exists!");			
      }
    
      else {
        userService.saveAdminUser(user);
        modelAndView.addObject("successMessage", "User is registered successfully!");
      }
      modelAndView.addObject("user", new User());
      modelAndView.setViewName("customer_new_admin");
      return modelAndView;
    }
    @RequestMapping(value="/editUser", method=RequestMethod.POST)
    public ModelAndView editUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
      ModelAndView modelAndView = new ModelAndView();
      // Check for the validations
      if(bindingResult.hasErrors()) {
        modelAndView.addObject("successMessage", "Please correct the errors in form!");
        modelMap.addAttribute("bindingResult", bindingResult);
      }
 
      else {
        userService.saveUser(user);
        modelAndView.addObject("successMessage", "User is edited successfully!");
       
      }
      modelAndView.addObject("user", new User());
      modelAndView.setViewName("customer_new");
      return modelAndView;
    }
   
    @RequestMapping("/editC/{user_id}")
    public ModelAndView showEditUserFrom(@PathVariable(name="user_id") int user_id){
      ModelAndView mav=new ModelAndView("customer_edit");
      User user= dao.findById(user_id).get();
      mav.addObject("user", user);
      return mav;
    }
    @RequestMapping("/deleteC/{user_id}")
    public String deleteUser(@PathVariable(name="user_id") int user_id){
      dao.deleteById(user_id);
      return "redirect:/main/customer_new";
    }

    @RequestMapping("/toMain")
    public String toMain(){
    
      return "redirect:/main/mainpage";
  } 
  
  
  }


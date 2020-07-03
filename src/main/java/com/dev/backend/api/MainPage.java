package com.dev.backend.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
@Controller
@RequestMapping("/main")
public class MainPage extends BookController{
 
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Login"); // resources/template/login.html
		return modelAndView;
	}
    @RequestMapping("/mainpage")
    public String MainP(){
        
        return "Main";
    }
    @Override
    @RequestMapping("/book")
    public String viewHomePage(Model model) {
    
        return super.viewHomePage(model);
    }
    @Override
    @RequestMapping("/customer")
    public String viewCustomPage(Model model) {
        
        return super.viewCustomPage(model);
    }
}
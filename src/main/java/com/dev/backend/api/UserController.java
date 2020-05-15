// package com.dev.backend.api;
// import com.dev.backend.model.Customer;
// import com.dev.backend.dao.CustomerDao;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import java.util.List;
// import org.springframework.web.servlet.ModelAndView;
// import org.springframework.web.bind.annotation.PathVariable;

// @Controller
// public abstract class CustomerController{
//     @Autowired
//     private CustomerDao dao;

//     public String viewCustomPage(Model model)
//     {
//      List<Customer> listCustomers=(List<Customer>)dao.findAll();

//       model.addAttribute("listCustomer", listCustomers);
//     return "customer_main";
//     }
//     @RequestMapping("/newC")
//     public String showNewUserFrom(Model model){
//       Customer customer=new Customer();
//       model.addAttribute("customer", customer);
//       return "customer_new";
//     }

//     @RequestMapping(value = "/saveC",method=RequestMethod.POST)
//     public String saveUser(@ModelAttribute("customer") Customer customer)
//     {   
//         String password=customer.getPassword();
//         char[] encode=password.toCharArray();
//         for(int i=0;i<encode.length;i++)
//         {  if(i%2==0)
//             encode[i]+=3;
//            else
//            encode[i]*=2;

//         }
//         String encoded =new String(encode);
//         customer.setPassword(encoded);
//         dao.save(customer);
//         return "redirect:/main/customer";
//     }

//     @RequestMapping("/editC/{user_id}")
//     public ModelAndView showEditUserFrom(@PathVariable(name="user_id") int user_id){
//       ModelAndView mav=new ModelAndView("customer_edit");
//       Customer customer= dao.findById(user_id).get();
//       mav.addObject("customer", customer);
//       return mav;
//     }
//     @RequestMapping("/deleteC/{user_id}")
//     public String deleteUser(@PathVariable(name="user_id") int user_id){
//       dao.deleteById(user_id);
//       return "redirect:/main/customer";
//     }

//     @RequestMapping("/toMain")
//     public String toMain(){

//       return "redirect:/main/mainpage";
//   } 

//   @RequestMapping(value = "/saveWeb",method=RequestMethod.POST)
//   public String saveWebUser(@ModelAttribute("customer") Customer customer)
//   {   
//       String password=customer.getPassword();
//       char[] encode=password.toCharArray();
//       for(int i=0;i<encode.length;i++)
//       {  if(i%2==0)
//           encode[i]+=3;
//          else
//          encode[i]*=2;

//       }
//       String encoded =new String(encode);
//       customer.setPassword(encoded);
//       dao.save(customer);
//       return "redirect:/webHome/webMain";
//   }

//   }

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
      // we will save the user if, no binding errors
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
      // we will save the user if, no binding errors
      else {
        userService.saveAdminUser(user);
        modelAndView.addObject("successMessage", "User is registered successfully!");
      }
      modelAndView.addObject("user", new User());
      modelAndView.setViewName("customer_new_admin");
      return modelAndView;
    }

    //     @RequestMapping(value = "/saveC",method=RequestMethod.POST)
//     public String saveUser(@ModelAttribute("customer") Customer customer)
//     {   
//         String password=customer.getPassword();
//         char[] encode=password.toCharArray();
//         for(int i=0;i<encode.length;i++)
//         {  if(i%2==0)
//             encode[i]+=3;
//            else
//            encode[i]*=2;

//         }
//         String encoded =new String(encode);
//         customer.setPassword(encoded);
//         dao.save(customer);
//         return "redirect:/main/customer";
//     }
   
    @RequestMapping("/editC/{user_id}")
    public ModelAndView showEditUserFrom(@PathVariable(name="user_id") int user_id){
      ModelAndView mav=new ModelAndView("customer_edit");
      User customer= dao.findById(user_id).get();
      mav.addObject("customer", customer);
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
  
  // @RequestMapping(value = "/saveWeb",method=RequestMethod.POST)
  // public String saveWebUser(@ModelAttribute("customer") Customer customer)
  // {   
  //     String password=customer.getPassword();
  //     char[] encode=password.toCharArray();
  //     for(int i=0;i<encode.length;i++)
  //     {  if(i%2==0)
  //         encode[i]+=3;
  //        else
  //        encode[i]*=2;
      
  //     }
  //     String encoded =new String(encode);
  //     customer.setPassword(encoded);
  //     dao.save(customer);
  //     return "redirect:/webHome/webMain";
  // }


  }


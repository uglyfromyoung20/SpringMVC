package rualtyshkinspringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
   @GetMapping("/hello")

   public  String HelloPage(@RequestParam (value="name", required=false) String name ,
                            @RequestParam (value="surname",required=false) String surname , Model model){
model.addAttribute("message","Hello" +  "," + name + " " + surname);
       //System.out.println("Hello"+ name + " " + surname);
       return "first/hello";
   }
   @GetMapping("/calculator")
   public String calculator(@RequestParam ( "a" ) int a , @RequestParam ("b")  int b ,
   @RequestParam ("action")  String action, Model model){
       double result;
       switch(action){
           case"multiplication":
               result=a * b;
               break;
           case"deprication":
               result=a / (double) b;
               break;
           case"substraction ":
               result=a - b;
               break;
           case"action":
               result=a + b;
               break;
           default :   // если пользователь ввел невалидную операцию , и у нас result остается непроинициализированным
               result = 0;
               break;


       }
       model.addAttribute("result",result);

       return "first/calculator";
   }

    @GetMapping("/goodbye")
   public String GoodbyePage(){
        return "first/goodbye";

   }
}

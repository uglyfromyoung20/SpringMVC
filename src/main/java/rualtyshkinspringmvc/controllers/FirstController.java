package rualtyshkinspringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {
   @GetMapping("/hello")

   public  String HelloPage(@RequestParam (value="name", required=false) String name ,
                            @RequestParam (value="surname",required=false) String surname , Model model){
model.addAttribute("message","Hello"+ name + " " + surname);
       //System.out.println("Hello"+ name + " " + surname);
       return "first/hello";
   }

    @GetMapping("/goodbye")
   public String GoodbyePage(){
        return "first/goodbye";

   }
}

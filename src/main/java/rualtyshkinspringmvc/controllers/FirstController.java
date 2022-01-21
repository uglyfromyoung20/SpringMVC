package rualtyshkinspringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
   @GetMapping("/hello")
   public  String HelloPage(){
       return "first/hello";
   }

    @GetMapping("/goodbye")
   public String GoodbyePage(){
        return "first/goodbye";

   }
}

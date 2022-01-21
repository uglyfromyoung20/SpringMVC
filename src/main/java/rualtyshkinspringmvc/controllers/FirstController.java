package rualtyshkinspringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {
   @GetMapping("/hello")
   public  String HelloPage(HttpServletRequest request ){
       String name = request.getParameter("name");
       String surname = request.getParameter("surname");
       System.out.println("Hello"+ name + " " + surname);
       return "first/hello";
   }

    @GetMapping("/goodbye")
   public String GoodbyePage(){
        return "first/goodbye";

   }
}

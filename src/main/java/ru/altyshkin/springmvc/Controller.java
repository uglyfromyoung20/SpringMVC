package ru.altyshkin.springmvc;


import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    //указание на то какой url будет приводить к данному методу
    @GetMapping("/Hello-world")
    public String sayHello(){
        return "hello_world";
    }
}

package rualtyshkinspringmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rualtyshkinspringmvc.DAO.PersonDao;
import rualtyshkinspringmvc.models.Person;


@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDao personDao;
    @Autowired
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDao.show(id));
        return "people/show";
    }
    @GetMapping("/new")
    public String newPerson(Model model){
model.addAttribute("person",new Person());

        return "people/new";
    }
    @PostMapping
    public String create(@ModelAttribute ("person") Person person){
        personDao.save(person);
        return "redirect:/people"; // совершается переход на другую страницу после добавки человека в базу данных

    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable ("id") int id){
model.addAttribute("person",personDao.show(id));
        return"people/edit";
    }
    @PatchMapping("/{id}")
        public String update(@ModelAttribute("person") Person person , @PathVariable("id") int id){
        personDao.update(id,person);
        return "redirect:/people";
    }
@DeleteMapping("/{id}")
    public String Delete(@PathVariable("id") int id){
        personDao.delete(id);
        return "redirect:/people";

}

}
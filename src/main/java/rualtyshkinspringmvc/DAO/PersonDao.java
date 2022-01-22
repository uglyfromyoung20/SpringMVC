package rualtyshkinspringmvc.DAO;

import org.springframework.stereotype.Component;
import rualtyshkinspringmvc.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDao {
    private List<Person> people ;
    {
        people = new ArrayList<>();

        people.add(new Person(15,"Leshka"));
        people.add(new Person(10 , "Kirill"));
        people.add(new Person(11 , "Akmal"));
        people.add(new Person(2 , "Alex"));


    }

    public List<Person> index() {
       return people;
    }
    public Person show(int id){
        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }
}

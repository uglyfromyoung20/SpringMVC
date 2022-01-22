package rualtyshkinspringmvc.DAO;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import rualtyshkinspringmvc.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDao {
    private int PEOPLE_COUNT;
    private List<Person> people ;
    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT,"Leshka",19,"294212@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT , "Kirill",19,"JavaDeveloper@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT , "Akmal",10,"geniy@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT , "Alex",0,"komandor@mail.ru"));


    }

    public List<Person> index() {
       return people;
    }
    public Person show(int id){
        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }
    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id , Person updatePerson){
     Person   personToBeUpdated = show(id);
     personToBeUpdated.setName(updatePerson.getName());
     personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }
    public void delete(int id){
        people.removeIf(p-> p.getId()== id);
    }
}

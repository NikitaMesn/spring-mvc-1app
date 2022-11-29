package ru.mesnyankin.spring.dao;

import org.springframework.stereotype.Component;
import ru.mesnyankin.spring.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    public static int PEOPLE_COUNT;
    private List<Person> people;


    {
        //инициализируется перед коструктором, уточнить в интернете
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Jack"));
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "John"));
        people.add(new Person(++PEOPLE_COUNT, "Anna"));
        people.add(new Person(++PEOPLE_COUNT, "Kate"));
        people.add(new Person(++PEOPLE_COUNT, "Bred"));
        people.add(new Person(++PEOPLE_COUNT, "Fred"));
    }


    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}

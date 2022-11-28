package ru.mesnyankin.spring.dao;

import org.springframework.stereotype.Component;
import ru.mesnyankin.spring.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;


    {
        people = new ArrayList<>();
        people.add(new Person(1, "Jack"));
        people.add(new Person(2, "Tom"));
        people.add(new Person(3, "John"));
        people.add(new Person(4, "Anna"));
        people.add(new Person(5, "Kate"));
        people.add(new Person(6, "Bred"));
        people.add(new Person(7, "Fred"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }
}

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
        people.add(new Person(++PEOPLE_COUNT, "Jack", 22, "jack@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Tom", 25, "tom@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "John", 24, "john@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Anna", 21, "anna@mail.com"));

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

    public void update(int id, Person person) {

        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(x -> x.getId() == id);
    }
}

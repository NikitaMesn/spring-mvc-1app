package ru.mesnyankin.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mesnyankin.spring.dao.PersonDAO;
import ru.mesnyankin.spring.model.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {


    private PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String index(Model model) {
        //Получим всех людей из DAO и передадим на отбражение в представление

        model.addAttribute("people", personDAO.index());

        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //Получим одного человека по его ид из ДАО и передадим на отображение в представление

        model.addAttribute("person", personDAO.show(id));

        return "people/show";
    }

/*
    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());

        return "people/new";
    }
*/

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }


    @PostMapping
    public String createPerson(@ModelAttribute("person") Person person) {
        /*
        Аннотации @ModelAttribute в пустом объекте person сохраняет значение полей из формы таймлиф
        */
        personDAO.save(person);

        return "redirect:people";  //делаем редирект на главную страцу
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));

        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personDAO.update(id, person);

        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);


        return "redirect:/people";
    }}

package ru.mesnyankin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/firstController") //все методы будут доступны только с /firstController
public class FirstController {
/*
*Способ с HttpServletRequest лучше использовать, если есть надобность в использование методов HttpServletRequest
*
*
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello, " + name + " " + surname);
        System.out.println(request.getParameterMap().entrySet().stream().map(e -> e.getKey() + ": " + Arrays.stream(e.getValue()).collect(Collectors.joining(", "))).collect(Collectors.joining("; ")));

        return "first/hello";
    }
*/

    @GetMapping("/hello") // без required = false, запрос без параметров вернет ошибку
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname) {

        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }


    @GetMapping("/goodbye")
    public String goodByePage() {

        return "first/goodbye";
    }
}

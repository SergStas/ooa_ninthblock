package com.example.ninthblock.controllers;

import com.example.ninthblock.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class EntryController {
    @Autowired
    private TodoService _todos;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
        map.put("header", "Shopping todos:");
        map.put("todos", _todos.getAll());
        return "index";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("label") String label) {
        _todos.add(label);
        return "redirect:/";
    }

    @RequestMapping(path = "/switch/{id}", method = RequestMethod.POST)
    public String switchIsDone(@PathVariable("id") int id) {
        _todos.switchIsDone(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/remove/{id}", method = RequestMethod.POST)
    public String remove(@PathVariable("id") int id) {
        _todos.remove(id);
        return "redirect:/";
    }
}

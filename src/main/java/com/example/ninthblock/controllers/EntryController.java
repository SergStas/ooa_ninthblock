package com.example.ninthblock.controllers;

import com.example.ninthblock.models.TodoEntry;
import com.example.ninthblock.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @ResponseBody
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Map<String, Object> add(@ModelAttribute("label") String label) {
        TodoEntry res = _todos.add(label);
        return Map.of(
                "label", label,
                "id", res.getId(),
                "updText", res.switchDoneStr()
        );
    }

    @ResponseBody
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Map<String, Boolean> switchIsDone(@PathVariable("id") int id) {
        boolean newState = _todos.switchIsDone(id);
        return Map.of("state", newState);
    }

    @ResponseBody
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable("id") int id) {
        _todos.remove(id);
        return "";
    }
}

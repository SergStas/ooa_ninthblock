package com.example.ninthblock.services;

import com.example.ninthblock.models.TodoEntry;
import com.example.ninthblock.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private int newIndex = 0;

    @Autowired
    private TodoRepository repository;

    public List<TodoEntry> getAll() {
        return new ArrayList<>(repository.getAll());
    }

    public void switchIsDone(int id) {
        repository.switchIsDone(id);
    }

    public void add(String label) {
        repository.add(new TodoEntry(++newIndex, label, false));
    }

    public void remove(int id) {
        repository.remove(id);
    }
}

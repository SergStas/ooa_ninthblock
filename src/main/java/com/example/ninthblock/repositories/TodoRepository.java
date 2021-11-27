package com.example.ninthblock.repositories;

import com.example.ninthblock.models.TodoEntry;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TodoRepository {
    private final Map<Integer, TodoEntry> entryMap = new HashMap<>();

    public void add(TodoEntry todo) {
        entryMap.put(todo.getId(), todo);
    }

    public Collection<TodoEntry> getAll() {
        return entryMap.values();
    }

    public boolean switchIsDone(Integer id) {
        return entryMap.get(id).switchIsDone();
    }

    public void remove(int id) {
        entryMap.remove(id);
    }
}

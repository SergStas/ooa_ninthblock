package com.example.ninthblock.models;

import java.io.Serializable;
import java.util.Objects;

public class TodoEntry implements Serializable {
    private final int id;

    private final String label;

    private boolean isDone;

    public TodoEntry(int id, String label, boolean isChecked) {
        this.id = id;
        this.label = label;
        this.isDone = isChecked;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public boolean switchIsDone() {
        this.isDone = !this.isDone;
        return this.isDone;
    }

    public String switchDoneStr() {
        return isDone ? "Uncheck" : "Check";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoEntry todoEntry = (TodoEntry) o;
        return id == todoEntry.id && label.equals(todoEntry.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label);
    }

    @Override
    public String toString() {
        return label;
    }
}

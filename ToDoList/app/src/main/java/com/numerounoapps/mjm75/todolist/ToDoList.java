package com.numerounoapps.mjm75.todolist;

import java.util.ArrayList;

public class ToDoList {

private ArrayList<ToDo> list;

public ToDoList() {
    list = new ArrayList<ToDo>();
    list.add(new ToDo("Meeting with Steve", 45, "High"));
    list.add(new ToDo("Conference Call", 30, "Low"));



}

    public ArrayList<ToDo> getList() {
        return new ArrayList<ToDo>(list);
    }
}

package com.numerounoapps.mjm75.todolist;

public class ToDo {

    private String taskName;
    private int taskDuration;
    private String taskPriority;

    public ToDo(String taskName, int taskDuration, String taskPriority) {
        this.taskName = taskName;
        this.taskDuration = taskDuration;
        this.taskPriority = taskPriority;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskPriority() {
        return taskPriority;
    }
}

package com.numerounoapps.mjm75.proactivescheduler2;

import java.util.Date;

public class TasksDetail {
    int id;
    String taskName, taskPriority,taskDate;


    public TasksDetail(int id, String taskName, String taskPriority, String taskDate) {
        this.id = id;
        this.taskName = taskName;
        this.taskPriority = taskPriority;
        this.taskDate = taskDate;
    }

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public String getTaskDate() {
        return taskDate;
    }

}

package com.numerounoapps.mjm75.proactivescheduler2;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class TasksMainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String DATABASE_NAME = "tasksdb";

    TextView textViewViewTasks;
    EditText editTextTaskName, editTextTaskDate;
    Spinner spinnerPriority;

    SQLiteDatabase tasksDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_main);

        textViewViewTasks = (TextView) findViewById(R.id.textViewViewTasksId);
        editTextTaskName = (EditText) findViewById(R.id.editTextNameId);
        editTextTaskDate = (EditText) findViewById(R.id.editTextDateId);
        spinnerPriority = (Spinner) findViewById(R.id.spinnerPriorityId);

        findViewById(R.id.buttonAddTaskId).setOnClickListener(this);
        textViewViewTasks.setOnClickListener(this);

        //creating a database
        tasksDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);

        createTaskTable();
    }

    /*
    this method will create the table
    and call this method everytime we will launch the application
    the  IF NOT EXISTS to the SQL so it will only create the table when the table is not already created
    */

    private void createTaskTable() {
        tasksDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS tasks (\n" +
                        "    id INTEGER NOT NULL CONSTRAINT tasks_pk PRIMARY KEY AUTOINCREMENT,\n" +
                        "    taskname varchar(200) NOT NULL,\n" +
                        "    taskpriority varchar(200) NOT NULL,\n" +
                        "    taskdate varchar(200) NOT NULL,\n" +
                        ");"
        );
    }


    //this method will validate the task name and date

    private boolean inputsAreCorrect(String taskName, String taskDate) {
        if (taskName.isEmpty()) {
            editTextTaskName.setError("Please enter a task");
            editTextTaskName.requestFocus();
            return false;
        }

        if (taskDate.isEmpty()) {
            editTextTaskDate.setError("Please enter task Date");
            editTextTaskDate.requestFocus();
            return false;
        }
        return true;
    }

    // method for  create operation

    private void addTask() {

        String taskName = editTextTaskName.getText().toString().trim();
        String taskDate = editTextTaskDate.getText().toString().trim();
        String taskPriority = spinnerPriority.getSelectedItem().toString();


        //validating the inptus
        if (inputsAreCorrect(taskName, taskDate)) {

            String insertSQL = "INSERT INTO tasks \n" +
                    "(taskname, taskpriority, taskdate )\n" +
                    "VALUES \n" +
                    "(?, ?, ?);";

            //using the same method execsql for inserting values
            //this time it has two parameters
            //first is the sql string and second is the parameters that is to be binded with the query
            tasksDatabase.execSQL(insertSQL, new String[]{taskName, taskPriority, taskDate});

            Toast.makeText(this, "Task Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAddTaskId:

                addTask();

                break;
            case R.id.textViewViewTasksId:

                startActivity(new Intent(this, TaskActivity.class));

                break;
        }
    }
}


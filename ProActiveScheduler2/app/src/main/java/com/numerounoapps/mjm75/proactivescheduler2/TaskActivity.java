package com.numerounoapps.mjm75.proactivescheduler2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity{

    List<TasksDetail> tasksDetailList;
    SQLiteDatabase tasksDatabase;
    ListView listViewTasks;
    TasksSQLLiteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        listViewTasks = (ListView) findViewById(R.id.listViewTasksId);
        tasksDetailList = new ArrayList<>();

        //opening the database
        tasksDatabase = openOrCreateDatabase(TasksMainActivity.DATABASE_NAME, MODE_PRIVATE, null);

        //this method will display the tasks in the list
        showTasksFromDatabase();
    }

    private void showTasksFromDatabase() {
        // for fetching all the employees
        Cursor cursorTasks = tasksDatabase.rawQuery("SELECT * FROM tasks", null);
        /*
        if the cursor has some data
        looping through all the records
        pushing each record in the employee list
        */
        if (cursorTasks.moveToFirst()) {

            do {

                tasksDetailList.add(new TasksDetail(
                        cursorTasks.getInt(0),
                        cursorTasks.getString(1),
                        cursorTasks.getString(2),
                        cursorTasks.getString(3)

                ));
            } while (cursorTasks.moveToNext());
        }
        //closing the cursor
        cursorTasks.close();

        //creating the adapter object
        adapter = new TasksSQLLiteAdapter(this, R.layout.list_layout_tasks, tasksDetailList, tasksDatabase);

        //adding the adapter to listview
        listViewTasks.setAdapter(adapter);
    }

}

package com.numerounoapps.mjm75.proactivescheduler2;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TasksSQLLiteAdapter extends ArrayAdapter<TasksDetail> {

    Context taskContext;
    int listLayoutRes;
    List<TasksDetail> taskDetailList;
    SQLiteDatabase tasksDatabase;

    public TasksSQLLiteAdapter(Context taskContext, int listLayoutRes, List<TasksDetail> tasksDetailList, SQLiteDatabase tasksDatabase) {
        super(taskContext, listLayoutRes, tasksDetailList);

        this.taskContext = taskContext;
        this.listLayoutRes = listLayoutRes;
        this.taskDetailList = tasksDetailList;
        this.tasksDatabase = tasksDatabase;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(taskContext);
        View view = inflater.inflate(listLayoutRes, null);

        final TasksDetail tasksDetail = taskDetailList.get(position);


        TextView textViewTaskName = view.findViewById(R.id.textViewTasknameId);
        TextView textViewPriority = view.findViewById(R.id.textViewPriorityId);
        TextView textViewTaskDate = view.findViewById(R.id.textViewtaskDateId);


        textViewTaskName.setText(tasksDetail.getTaskName());
        textViewPriority.setText(tasksDetail.getTaskPriority());
        textViewTaskDate.setText(tasksDetail.getTaskDate());


        Button buttonDelete = view.findViewById(R.id.buttonDeleteTask);
        Button buttonEdit = view.findViewById(R.id.buttonEditTaskId);

        //adding a clicklistener to button
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTask(tasksDetail);
            }
        });

        //the delete operation

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(taskContext);
                builder.setTitle("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sql = "DELETE FROM tasks WHERE id = ?";
                        tasksDatabase.execSQL(sql, new Integer[]{tasksDetail.getId()});
                        reloadTaskFromDatabase();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return view;
    }

    private void updateTask(final TasksDetail tasksDetail) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(taskContext);

        LayoutInflater inflater = LayoutInflater.from(taskContext);
        View view = inflater.inflate(R.layout.dialog_update_task, null);
        builder.setView(view);


        final EditText editTextTaskName = view.findViewById(R.id.editTextNameId);
        final EditText editTextTaskDate = view.findViewById(R.id.editTextDateId);
        final Spinner spinnerPriority = view.findViewById(R.id.spinnerPriorityId);

        editTextTaskName.setText(tasksDetail.getTaskName());
        editTextTaskDate.setText(tasksDetail.getTaskDate());


        final AlertDialog dialog = builder.create();
        dialog.show();

        view.findViewById(R.id.buttonUpdateTaskId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String taskName = editTextTaskName.getText().toString().trim();
                String taskDate = editTextTaskDate.getText().toString().trim();
                String taskPriority = spinnerPriority.getSelectedItem().toString();


                if (taskName.isEmpty()) {
                    editTextTaskName.setError("Task Name can't be blank");
                    editTextTaskName.requestFocus();
                    return;
                }

                if (taskDate.isEmpty()) {
                    editTextTaskDate.setError("Task Date can't be blank");
                    editTextTaskDate.requestFocus();
                    return;
                }

                String sql = "UPDATE tasks \n" +
                        "SET taskname = ?, \n" +
                        "taskpriority = ?, \n" +
                        "taskdate = ? \n" +
                        "WHERE id = ?;\n";

                tasksDatabase.execSQL(sql, new String[]{taskName, taskPriority, taskDate, String.valueOf(tasksDetail.getId())});

                Toast.makeText(taskContext, "Task Updated", Toast.LENGTH_SHORT).show();
                reloadTaskFromDatabase();
                dialog.dismiss();
            }
        });
    }

    private void reloadTaskFromDatabase() {
        Cursor cursorTasks = tasksDatabase.rawQuery("SELECT * FROM tasks", null);
        if (cursorTasks.moveToFirst()) {
            taskDetailList.clear();
            do {
                taskDetailList.add(new TasksDetail(
                        cursorTasks.getInt(0),
                        cursorTasks.getString(1),
                        cursorTasks.getString(2),
                        cursorTasks.getString(3)
                ));
            } while (cursorTasks.moveToNext());
        }
        cursorTasks.close();
        notifyDataSetChanged();
    }



}

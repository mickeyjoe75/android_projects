package com.numerounoapps.mjm75.proactivetaskscheduler;

import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class TaskMainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView date;
    SqlDbHelper sqlDbHelper;
    ArrayAdapter<String> mAdapter;
    ListView lstTask;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_taskDetailId:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.calendarViewId:
                    mTextMessage.setText(R.string.title_calenderview);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        //create a date string.
        String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
        //get hold of textview.
        date = findViewById(R.id.dateTextId);
        //set it as current date.
        date.setText(date_n);

        sqlDbHelper = new SqlDbHelper(this);

        lstTask = (ListView)findViewById(R.id.listTaskId);

        loadTaskList();

    }

    private void loadTaskList() {
        ArrayList<String> taskList = sqlDbHelper.getTaskList();
        if(mAdapter==null){
            mAdapter = new ArrayAdapter<String>(this,R.layout.row,R.id.taskTitleId,taskList);
            lstTask.setAdapter(mAdapter);
        }
        else{
            mAdapter.clear();
            mAdapter.addAll(taskList);
            mAdapter.notifyDataSetChanged();
        }
    }
// Adding the popup menu and add item options.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        //Change menu icon color
        Drawable icon = menu.getItem(0).getIcon();
        icon.mutate();
        icon.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_task:
                final EditText taskEditText = new EditText(this);
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Add New Task")
                        .setMessage("What do you want to do next?")
                        .setView(taskEditText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEditText.getText());
                                sqlDbHelper.insertNewTask(task);
                                loadTaskList();
                            }
                        })
                        .setNegativeButton("Cancel",null)
                        .create();
                dialog.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void deleteTask(View view){
        View parent = (View)view.getParent();
        TextView taskTextView = (TextView)parent.findViewById(R.id.taskTitleId);
        Log.e("String", (String) taskTextView.getText());
        String task = String.valueOf(taskTextView.getText());
        sqlDbHelper.deleteTask(task);
        loadTaskList();
    }

}

package com.numerounoapps.mjm75.menutestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //this will be called when the activity loads.

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main,menu);
        return true;
    }

    @Override
    public boolean  onOptionsItemSelected(MenuItem item) {

//        This will be called when the menu item gets clicked.

        if (item.getItemId() == R.id.action_hello) {
            Toast.makeText(MenuActivity.this, R.string.menu_toast_hello, Toast.LENGTH_SHORT).show();
                    return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

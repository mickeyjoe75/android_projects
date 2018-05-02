package com.numerounoapps.mjm75.proactivetaskscheduler;

import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

public class CalenderViewActivity extends AppCompatActivity {

    private CalendarView calenderView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_view);

        calenderView = findViewById(R.id.calendarViewId);

    }

    public void onClickCalendar(View MenuItem) {

        calenderView.getWeekDayTextAppearance();

    }

}

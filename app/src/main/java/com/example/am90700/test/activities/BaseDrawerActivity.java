package com.example.am90700.test.activities;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.am90700.test.R;
import com.example.am90700.test.listeners.DrawerClickListener;

public abstract class BaseDrawerActivity extends AppCompatActivity {

    private String[] sections;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        sections = getResources().getStringArray(R.array.sections);
        drawerLayout = (DrawerLayout) findViewById(R.id.menu_drawer);
        drawerList = (ListView) findViewById(R.id.drawer_list);

        drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_section, sections));
        drawerList.setOnItemClickListener(new DrawerClickListener());

        Log.d("DRAWER", "START");

        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Log.d("DRAWER", "OPENED");
                invalidateOptionsMenu();

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.d("DRAWER", "CLOSED");
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                invalidateOptionsMenu();
            }
        };

        drawerLayout.addDrawerListener(drawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(android.R.id.home == item.getItemId()){
            Log.d("ACTIONBAR", "HOME BUTTON PRESSED");
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }

        if (drawerToggle.onOptionsItemSelected(item)) {

            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}

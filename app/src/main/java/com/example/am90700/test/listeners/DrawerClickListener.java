package com.example.am90700.test.listeners;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.am90700.test.R;

/**
 * Created by am90700 on 17-10-26.
 */

public class DrawerClickListener implements AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("DRAWER", ((TextView) view.findViewById(R.id.drawer_section)).getText().toString());
    }
}

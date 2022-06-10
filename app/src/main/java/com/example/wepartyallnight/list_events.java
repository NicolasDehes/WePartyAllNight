package com.example.wepartyallnight;

import androidx.appcompat.app.AppCompatActivity;
import com.example.wepartyallnight.Model.beans.Event;
import com.example.wepartyallnight.Model.dao.EventsDao;

import android.os.Bundle;

public class list_events extends AppCompatActivity {
    // private final List<Event> musiciensList = new ArrayList<Event>();
    // private ArrayAdapter<Event> listViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventsDao e = new EventsDao();

        e.getAllEvents();

        setContentView(R.layout.activity_list_events);
    }
}
package com.example.wepartyallnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class dashboard extends AppCompatActivity {
    private Button btn_new_event;
    private Button btn_envents;
    private Button btn_n_envents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btn_envents = (Button) findViewById(R.id.btn_list_events);
        btn_n_envents = (Button) findViewById(R.id.btn_new_event);

        btn_envents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(list_events.class);
            }
        });
        btn_n_envents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(list_events.class);
            }
        });
    }
    private void openPage(Class<?> page) {
        Intent switchActivityIntent = new Intent(this, page);
        startActivity(switchActivityIntent);
    }
}
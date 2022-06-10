package com.example.wepartyallnight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText pseudo;
    private EditText pwd;
    private Button btn_sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_sign_in = (Button) findViewById(R.id.sign_in);
        pseudo = (EditText) findViewById(R.id.pseudo);
        pwd = (EditText) findViewById(R.id.password);

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pseudo.getText().length() > 0 && pwd.getText().length() > 0) {



                    openAppDashboard();
                } else {
                    String toastMessage = "Pseudo or Phone are not populated";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void openAppDashboard() {
        Intent switchActivityIntent = new Intent(this, dashboard.class);
        startActivity(switchActivityIntent);
    }
}
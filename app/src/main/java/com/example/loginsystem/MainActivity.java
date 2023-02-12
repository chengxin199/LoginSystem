package com.example.loginsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button register_btn,login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_btn = findViewById(R.id.button2);
        register_btn = findViewById(R.id.button);

        //received the string from register page, then store as boolean, if true, button enable
        boolean registrationSuccess = getIntent().getBooleanExtra("success", false);
        if (registrationSuccess) {
            login_btn.setEnabled(true);
        }
    }
//register button intent to register page
    public void btn_click(View v) {
        Intent mainIntent = new Intent(MainActivity.this, Register.class);
        startActivity(mainIntent);
    }
//login button intent to login page
    public void btn_click1(View v) {
        Intent mainIntent = new Intent(MainActivity.this, Login.class);
        startActivity(mainIntent);
    }

}
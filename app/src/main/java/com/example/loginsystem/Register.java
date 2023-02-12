package com.example.loginsystem;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class Register extends AppCompatActivity {
    EditText last_name,first_name,birth,email,password;
    Button register;
    TextView success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        last_name = findViewById(R.id.last_name);
        first_name = findViewById(R.id.first_name);
        birth = findViewById(R.id.data_birth);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        success = findViewById(R.id.success);


        register.setOnClickListener(v -> {
            //function to check string length and validation
        checkLength();
        // if validation success, direct back to home page and send string to enable login button
        if(checkValidate()) {
            Intent mainIntent = new Intent(Register.this,MainActivity.class);
            mainIntent.putExtra("success", true);
            Register.this.startActivity(mainIntent);
        }
        });

    }
//you can also go back to home page by click the button
    public void back(View v){
        Intent mainIntent = new Intent(Register.this,MainActivity.class);
        Register.this.startActivity(mainIntent);
    }
//check if edittext empty
    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
//check the email format
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
//function to check string length
    void checkLength(){
        if (last_name.getText().length()<3){
            last_name.setError("too short,please increase your character above 3");
        }else if(last_name.getText().length()>=30){
            last_name.setError("too long, please reduce your character within 30");
        }

        if (first_name.getText().length()<3){
            first_name.setError("too short,please increase your character above 3");
        }else if(first_name.getText().length()>=30){
            first_name.setError("too long, please reduce your character within 30");
        }

        if (password.getText().length()<3){
            password.setError("too short,please increase your character above 3");
        }else if(password.getText().length()>=30){
            password.setError("too long, please reduce your character within 30");
        }
    }
//function to check data validation
    boolean checkValidate(){
        if (isEmpty(last_name)){
            Toast t =Toast.makeText(this,"you need to enter last name",Toast.LENGTH_SHORT);
            t.show();
            return false;
        }
        if (isEmpty(first_name)){
            Toast t =Toast.makeText(this,"you need to enter first name",Toast.LENGTH_SHORT);
            t.show();
            return false;
        }
        if (isEmpty(birth)){
            Toast t =Toast.makeText(this,"you need to enter date of birth",Toast.LENGTH_SHORT);
            t.show();
            return false;
        }

        if (isEmpty(email)){
            Toast t =Toast.makeText(this,"you need to enter email",Toast.LENGTH_SHORT);
            t.show();
            return false;
        }
        if (isEmpty(password)){
            Toast t =Toast.makeText(this,"you need to enter password",Toast.LENGTH_SHORT);
            t.show();
            return false;

        }
        if (isEmail(email)==false) {
            email.setError("Enter valid email!");
            return false;
        }
        return true;
    }

}







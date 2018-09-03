package com.example.shaochengyang.signupscreenwithvalidation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText userText, passwordText, dobText, emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        userText=findViewById(R.id.userNameText);
        passwordText=findViewById(R.id.passText);
        //passwordText.setAlpha(0.0f);
        passwordText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        dobText = findViewById(R.id.dobText);
        emailText = findViewById(R.id.emailText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, password, dob,email;
                username=userText.getText().toString();
                password=passwordText.getText().toString();

                dob=dobText.getText().toString();
                email=emailText.getText().toString();

                final String USER_PATTERN = "^[a-zA-Z0-9._-]{3,10}$";
                final String PASS_PATTERN = "^[A-Za-z0-9.-_!]{6,18}$";
                final String DOB_PATTERN = "^(\\d{2}-?\\d{2}-?\\d{4})$";
                final String EMAIL_PATTERN = "^[a-zA-Z0-9._-]{3,20}@[a-zA-Z0-9]{3,9}.com$";

                if(!Pattern.matches(USER_PATTERN, username)){
                    Toast.makeText(getApplicationContext(),"user name not validate",Toast.LENGTH_SHORT).show();

                }
                else if(!Pattern.matches(EMAIL_PATTERN,email)){
                    Toast.makeText(getApplicationContext(),"email not validate",Toast.LENGTH_SHORT).show();
                }

                else if(!Pattern.matches(PASS_PATTERN,password)){
                    Toast.makeText(getApplicationContext(),"password not validate",Toast.LENGTH_SHORT).show();
                }
                else if(!Pattern.matches(DOB_PATTERN,dob)){
                    Toast.makeText(getApplicationContext(),"birthday not validate",Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(getApplicationContext(),"signup success!",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,Success.class);
                    startActivity(i);
                }




            }
        });

    }


}

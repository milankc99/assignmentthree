package com.example.assignmentthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText name, password;
    Button login;
    private  int counter = 5;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = findViewById(R.id.User);
        password = findViewById(R.id.Pass);
        login = findViewById(R.id.btnlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
    }
    public  void  validate(String name, String password){
        if ((name.equals("") || password.equals(""))) {

            return;
        }
        if (name.equals("softwarica") && password.equals("coventry")){
            Toast.makeText(getApplicationContext(),"Login Sucessful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            counter --;
            error.setText("No fo attempts remaining: "+String.valueOf(counter));

            if (counter ==0){
                login.setEnabled(false);
            }
        }
    }
}

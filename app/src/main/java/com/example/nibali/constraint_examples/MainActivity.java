package com.example.nibali.constraint_examples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText password = (EditText) findViewById(R.id.password);
        password.setTransformationMethod(new PasswordTransformationMethod());

        sign_in = (Button) findViewById(R.id.sign_in);
        sign_in.setOnClickListener(
                (view) -> {
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(intent);
                }
        );
    }
}

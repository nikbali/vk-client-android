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
    private Button sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText password = (EditText) findViewById(R.id.password);
        password.setTransformationMethod(new PasswordTransformationMethod());

        sign_in = findViewById(R.id.sign_in);
        sign_in.setOnClickListener(
                (view) -> {
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(intent);
                }
        );

        sign_up = findViewById(R.id.sign_up);
        sign_up.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NavigationProfile.class);
            startActivity(intent);
        });
    }
}

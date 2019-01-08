package com.example.nibali.constraint_examples.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.nibali.constraint_examples.R;

/**
 * Created by nibali on 24.11.2018.
 */

public class ProfileActivity extends AppCompatActivity {

    private Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        menu = (Button) findViewById(R.id.buttonMenu);
        menu.setOnClickListener(
                (view) -> {
                    Intent intent = new Intent(ProfileActivity.this, PostsActivity.class);
                    startActivity(intent);
                }
        );
    }
}

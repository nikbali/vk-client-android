package com.example.nibali.constraint_examples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

public class MainActivity extends AppCompatActivity {

    private Button sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText password = (EditText) findViewById(R.id.password);
        password.setTransformationMethod(new PasswordTransformationMethod());
        sign_up = findViewById(R.id.sign_up);
        sign_up.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NavigationProfile.class);
            startActivity(intent);
        });
        VKSdk.login(this, VKScope.STATUS, VKScope.FRIENDS, VKScope.MESSAGES);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                Toast.makeText(MainActivity.this,"Успех!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, NavigationProfile.class);
                startActivity(intent);
            }

            @Override
            public void onError(VKError error) {
                Toast.makeText(MainActivity.this,"Error auth", Toast.LENGTH_LONG).show();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

package com.example.nibali.constraint_examples.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nibali.constraint_examples.Application;
import com.example.nibali.constraint_examples.R;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiUser;
import com.vk.sdk.api.model.VKList;

public class LoginActivity extends AppCompatActivity {

    private Button sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (VKSdk.isLoggedIn()) {
            createUserComponentAndLaunchMainActivity();
            return;
        }

        setContentView(R.layout.activity_login);
        EditText password = (EditText) findViewById(R.id.password);
        password.setTransformationMethod(new PasswordTransformationMethod());
        sign_up = findViewById(R.id.sign_up);


        sign_up.setOnClickListener(view -> {
            VKSdk.login(this, VKScope.STATUS, VKScope.FRIENDS, VKScope.MESSAGES);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                createUserComponentAndLaunchMainActivity();
            }

            @Override
            public void onError(VKError error) {
                Toast.makeText(LoginActivity.this,"Error auth", Toast.LENGTH_LONG).show();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @SuppressWarnings("unchecked")
    private void createUserComponentAndLaunchMainActivity() {
        VKApi.users().get(VKParameters.from(VKApiConst.FIELDS, "photo_big")).executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                VKList<VKApiUser> users = (VKList<VKApiUser>) response.parsedModel;

                ((Application) getApplication()).createUserComponent(users.get(0));

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                overridePendingTransition(0, 0);

                finish();
            }
        });
    }
}

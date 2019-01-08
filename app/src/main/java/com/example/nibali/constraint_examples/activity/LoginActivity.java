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
import com.example.nibali.constraint_examples.*;
import com.example.nibali.constraint_examples.api.UserApi;
import com.example.nibali.constraint_examples.base.AbstractBaseActivity;
import com.example.nibali.constraint_examples.databinding.ActivityLoginBinding;
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

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AbstractBaseActivity {

    @Inject
    Retrofit retrofit;

    @Override
    protected void inject() {
        ((Application) getApplication()).getAppComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (VKSdk.isLoggedIn()) {
            createUserComponentAndLaunchMainActivity(VKAccessToken.currentToken());
            return;
        }
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.signIn.setOnClickListener(view -> {
            VKSdk.login(this, VKScope.STATUS, VKScope.FRIENDS, VKScope.MESSAGES);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                createUserComponentAndLaunchMainActivity(res);
            }

            @Override
            public void onError(VKError error) {
                Toast.makeText(LoginActivity.this, "Error auth", Toast.LENGTH_LONG).show();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @SuppressWarnings("unchecked")
    private void createUserComponentAndLaunchMainActivity(final VKAccessToken vkAccessToken ) {

        //Create a retrofit call object
        Call<List<VKApiUser>> user = retrofit.create(UserApi.class).getProfileInfo();

        user.enqueue(new Callback<List<VKApiUser>>() {
            @Override
            public void onResponse(Call<List<VKApiUser>> call, Response<List<VKApiUser>> response) {
                List<VKApiUser> users =  response.body();
                ((Application) getApplication()).createUserComponent(users.get(0), vkAccessToken);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                overridePendingTransition(0, 0);

                finish();

            }
            @Override
            public void onFailure(Call<List<VKApiUser>> call, Throwable t) {
                //Set the error to the textview

            }
        });
/*
        VKApi.users().get(VKParameters.from(VKApiConst.FIELDS, "photo_big")).executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                VKList<VKApiUser> users = (VKList<VKApiUser>) response.parsedModel;
                ((Application) getApplication()).createUserComponent(users.get(0), vkAccessToken);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                overridePendingTransition(0, 0);

                finish();
            }
        });
*/
    }
}

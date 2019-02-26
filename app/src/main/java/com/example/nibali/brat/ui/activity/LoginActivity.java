package com.example.nibali.brat.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nibali.brat.BratApplication;
import com.example.nibali.brat.*;
import com.example.nibali.brat.api.UserApi;
import com.example.nibali.brat.base.AbstractBaseActivity;
import com.example.nibali.brat.databinding.ActivityLoginBinding;
import com.example.nibali.brat.api.BaseResponse;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.model.VKApiUser;

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

        ((BratApplication) getApplication()).getAppComponent().inject(this);
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
            VKSdk.login(this, VKScope.STATUS, VKScope.FRIENDS, VKScope.MESSAGES,VKScope.WALL);
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
        Call<BaseResponse<List<VKApiUser>>> user = retrofit.create(UserApi.class).getProfileInfo(vkAccessToken.accessToken);

        user.enqueue(new Callback<BaseResponse<List<VKApiUser>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<VKApiUser>>>call, Response<BaseResponse<List<VKApiUser>>> response) {
                List<VKApiUser> users =  response.body().getResponse();
                ((BratApplication) getApplication()).createUserComponent(users.get(0), vkAccessToken);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(0, 0);

                finish();

            }
            @Override
            public void onFailure(Call<BaseResponse<List<VKApiUser>>> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Жесть!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}

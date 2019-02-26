package com.example.nibali.brat.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import icepick.Icepick;


public abstract class AbstractBaseActivity extends AppCompatActivity {
    protected abstract void inject();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        inject();
        Icepick.restoreInstanceState(this, savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }
}

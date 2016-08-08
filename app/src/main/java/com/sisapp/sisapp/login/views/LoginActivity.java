package com.sisapp.sisapp.login.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.sisapp.sisapp.R;

/**
 * Created by Elmost on 4/08/2016.
 */
public class LoginActivity extends AppCompatActivity implements LoginViewInterface {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AdView mAdView = (AdView) findViewById(R.id.loginBannerAdsBottom);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


    @Override
    public void enableInputs() {

    }

    @Override
    public void disableInputs() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void handleSignUp() {

    }

    @Override
    public void handleSignIn() {

    }

    @Override
    public void handleSignInGoogle() {

    }

    @Override
    public void goToMainScreen() {

    }

    @Override
    public void handleErrors(String error) {

    }

    @Override
    public void handleSuccess() {

    }
}

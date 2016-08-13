package com.sisapp.sisapp.login.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.sisapp.sisapp.R;
import com.sisapp.sisapp.login.presenters.LoginPresenter;
import com.sisapp.sisapp.login.presenters.LoginPresenterImpl;
import com.sisapp.sisapp.main.views.MainActivityImpl;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Elmost on 4/08/2016.
 */
public class LoginActivityImpl extends AppCompatActivity implements LoginActivity, GoogleApiClient.OnConnectionFailedListener {

    public static final String MESSAGE_REQUIRED = "Required field";
    private static final int RC_SIGN_IN = 9001;

    @Bind(R.id.loginOutputLogo)
    ImageView loginOutputLogo;
    @Bind(R.id.loginInputEmail)
    EditText loginInputEmail;
    @Bind(R.id.loginWrapperEmail)
    TextInputLayout loginWrapperEmail;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.loginInputPassword)
    EditText loginInputPassword;
    @Bind(R.id.loginWrapperPassword)
    TextInputLayout loginWrapperPassword;
    @Bind(R.id.loginBtnSignInSisApp)
    Button loginBtnSignInSisApp;
    @Bind(R.id.loginBtnSignUpSisApp)
    Button loginBtnSignUpSisApp;
    @Bind(R.id.loginLayoutButtons)
    LinearLayout loginLayoutButtons;
    @Bind(R.id.loginBtnSignInGoogle)
    SignInButton loginBtnSignInGoogle;
    @Bind(R.id.loginLayoutAuthFederated)
    LinearLayout loginLayoutAuthFederated;
    @Bind(R.id.loginBannerAdsBottom)
    AdView loginBannerAdsBottom;
    @Bind(R.id.loginLayoutBanner)
    LinearLayout loginLayoutBanner;
    @Bind(R.id.loginContent)
    RelativeLayout loginContent;
    @Bind(R.id.loginScroll)
    ScrollView loginScroll;
    @Bind(R.id.loginContainer)
    LinearLayout loginContainer;

    private GoogleApiClient mGoogleApiClient = null;
    private GoogleSignInOptions mGoogleSignInOptions = null;
    private LoginPresenter mPresenter = null;
    private AdRequest mAdRequest = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        this.mGoogleSignInOptions = new
                GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestProfile()
                .build();

        this.mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, mGoogleSignInOptions)
                .build();

        this.loginBtnSignInGoogle.setSize(SignInButton.SIZE_WIDE);
        this.loginBtnSignInGoogle.setScopes(mGoogleSignInOptions.getScopeArray());


        this.mPresenter = new LoginPresenterImpl(this);
        this.mPresenter.onCreate();
        this.mPresenter.toCheckForAuthenticatedUser();

        this.loginBannerAdsBottom = (AdView) findViewById(R.id.loginBannerAdsBottom);
        this.mAdRequest = new AdRequest.Builder().build();
        this.loginBannerAdsBottom.loadAd(this.mAdRequest);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    /**
     * Habilitar de entradas.
     */
    @Override
    public void enableInputs() {
        setInputs(ENABLE);
    }

    /**
     * Desactivar las entradas.
     */
    @Override
    public void disableInputs() {
        setInputs(DISABLE);
    }

    /**
     * Mostrar barra de progreso.
     */
    @Override
    public void showProgress() {
        this.progressBar.setVisibility(View.VISIBLE);
    }

    /**
     * Ocultar barra de progreso.
     */
    @Override
    public void hideProgress() {
        this.progressBar.setVisibility(View.GONE);
    }

    /**
     * Encargarse del registro en SisApp.
     */
    @Override
    @OnClick(R.id.loginBtnSignUpSisApp)
    public void handleSignUpSisApp() {
        String fEmail = this.loginInputEmail.getText().toString().trim();
        String fPassword = this.loginInputPassword.getText().toString().trim();
        mPresenter.toSignUpSisApp(fEmail, fPassword);
    }

    /**
     * Encargarce del inicio de sesión en SisApp.
     */
    @Override
    @OnClick(R.id.loginBtnSignInSisApp)
    public void handleSignInSisApp() {
        if (validateInputsFields()) {
            String fEmail = this.loginInputEmail.getText().toString().trim();
            String fPassword = this.loginInputPassword.getText().toString().trim();
            mPresenter.toSignInSisApp(fEmail, fPassword);
        }
    }

    /**
     * Encargarce del inicio de sesión con google.
     */
    @Override
    @OnClick(R.id.loginBtnSignInGoogle)
    public void handleSignInGoogle() {
        if (validateInputsFields()) {
            Intent mIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
            startActivityForResult(mIntent, RC_SIGN_IN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult mGoogleSignInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(mGoogleSignInResult);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount mGoogleSignInAccount = result.getSignInAccount();
            Log.i("GOOGLE-SESSION", mGoogleSignInAccount.getDisplayName());
            Log.i("GOOGLE-SESSION", mGoogleSignInAccount.getEmail());
            Log.i("GOOGLE-SESSION", mGoogleSignInAccount.getFamilyName());
            Log.i("GOOGLE-SESSION", mGoogleSignInAccount.getGivenName());
            Log.i("GOOGLE-SESSION", mGoogleSignInAccount.getId());
            Log.i("GOOGLE-SESSION", mGoogleSignInAccount.getIdToken());
            Log.i("GOOGLE-SESSION", mGoogleSignInAccount.getPhotoUrl().toString());
            Log.i("GOOGLE-SESSION", mGoogleSignInAccount.getServerAuthCode());
            navigateToMain();
        }
    }

    private void signOutGoogle() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                onError(status.getStatusMessage());
            }
        });
    }

    /**
     * En caso de error.
     *
     * @param error
     */
    @Override
    public void onError(String error) {
        Snackbar.make(this.loginContainer, error, Snackbar.LENGTH_LONG).show();
    }

    /**
     * En caso de éxito.
     */
    @Override
    public void onSucces() {
        navigateToMain();
    }

    private void setInputs(Boolean value) {
        this.loginInputEmail.setEnabled(value);
        this.loginInputPassword.setEnabled(value);
        this.loginBtnSignInSisApp.setEnabled(value);
        this.loginBtnSignUpSisApp.setEnabled(value);
        this.loginBtnSignInGoogle.setEnabled(value);
    }

    private void navigateToMain() {
        startActivity(new Intent(this, MainActivityImpl.class));
    }

    private Boolean validateInputsFields() {
        if (this.loginInputEmail.getText().toString().equals("")) {
            this.loginInputEmail.setError(MESSAGE_REQUIRED);
            return true;
        }
        if (this.loginInputPassword.getText().toString().equals("")) {
            this.loginInputPassword.setError(MESSAGE_REQUIRED);
            return true;
        }
        return true;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}

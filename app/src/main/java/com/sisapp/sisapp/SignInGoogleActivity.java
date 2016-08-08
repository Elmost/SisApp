package com.sisapp.sisapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.logging.Logger;

/**
 * Created by Elmost on 4/08/2016.
 */
public class SignInGoogleActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    private static final Logger LOGGER = Logger.getLogger(SignInGoogleActivity.class.getName());

    String p = getString(R.string.default_web_client_id);

    // código de inicio de sesión con google.
    private static final int CODE_SIGN_IN_GOOGLE = 9001;

    /**
     * Google gestor de credenciales de la cuenta.
     */

    private GoogleSignInOptions mGoogleSignInOptions;
    private GoogleApiClient mGoogleApiClient;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_google);
    }


    // Si ocurre un error en la conexión con el GoogleApiClient
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e(LOGGER.getName(), "onConnectionFailed : " + connectionResult.getErrorMessage());
    }

    @Override
    public void onClick(View view) {

    }
}

package com.sisapp.sisapp.settings;

import android.content.res.Resources;

import com.sisapp.sisapp.R;

/**
 * Created by Elmost on 5/08/2016.
 */
public class Setting {

    public static final String DEFAULT_WEB_CLIENT_ID = Resources.getSystem().getString(R.string.default_web_client_id);

    public static final String FIREBASE_DATABASE_URL = Resources.getSystem().getString(R.string.firebase_database_url);

    public static final String GCM_DEFAULT_SENDER_ID = Resources.getSystem().getString(R.string.gcm_defaultSenderId);

    public static final String GOOGLE_API_KEY = Resources.getSystem().getString(R.string.google_api_key);

    public static final String GOOGLE_APP_ID = Resources.getSystem().getString(R.string.google_app_id);

    public static final String GOOGLE_CRASH_REPORTING_API_KEY = Resources.getSystem().getString(R.string.google_crash_reporting_api_key);

    public static final String GOOGLE_STORAGE_BUCKET = Resources.getSystem().getString(R.string.google_storage_bucket);

}

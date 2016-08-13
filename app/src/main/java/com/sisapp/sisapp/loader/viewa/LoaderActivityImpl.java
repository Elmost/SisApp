package com.sisapp.sisapp.loader.viewa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;
import com.sisapp.sisapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Elmost on 4/08/2016.
 */
public class LoaderActivityImpl extends AppCompatActivity {

    @Bind(R.id.activity_loader_tvtitle)
    TextView activityLoaderTvtitle;
    @Bind(R.id.loaderIcon)
    ImageView loaderIcon;
    @Bind(R.id.loaderOutputMessage)
    TextView loaderOutputMessage;
    @Bind(R.id.loaderProgressBar)
    ProgressBar loaderProgressBar;
    @Bind(R.id.loaderBannerAds)
    AdView loaderBannerAds;
    @Bind(R.id.loaderContentLayout)
    LinearLayout loaderContentLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        ButterKnife.bind(this);
    }
}

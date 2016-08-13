package com.sisapp.sisapp.main.views;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.sisapp.sisapp.R;
import com.sisapp.sisapp.app.SisAppApplication;
import com.sisapp.sisapp.main.presenters.MainPresenter;
import com.sisapp.sisapp.main.presenters.MainPresenterImpl;
import com.sisapp.sisapp.pojos.User;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

// Carga el anuncios

public class MainActivityImpl extends AppCompatActivity implements MainActivity {

    @Bind(R.id.mainToolbar)
    Toolbar mainToolbar;
    @Bind(R.id.mainAppBarLayout)
    AppBarLayout mainAppBarLayout;
    @Bind(R.id.mainContent)
    RelativeLayout mainContent;
    @Bind(R.id.mainCordinator)
    CoordinatorLayout mainCordinator;
    @Bind(R.id.btnMas)
    Button btnMas;

    private MainPresenter mPresenter;
    private User mUser;
    private SisAppApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        application = (SisAppApplication) getApplication();
        mPresenter = new MainPresenterImpl(this);
        mPresenter.onCreate();
        mainToolbar.setSubtitle("oscardavid@jmspro.net");
        setSupportActionBar(mainToolbar);
    }

    @OnClick(R.id.btnMas)
    public void addClick() {
        int clic = mUser.getCurrentClicks() + 1;
        double cash = mUser.getCurrentCash() + 50;
        User user = new User(mUser.getEmail(), clic, cash, true);
        updateUser(user);
    }

    private void updateUser(User user) {
        mPresenter.onUpdateUser(user);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.toSubscribeUserUpdates();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_main_action_logout:
                signOff();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void signOff() {
        //Snackbar.make(this.mainContent, application.getmUser().toString(), Snackbar.LENGTH_LONG).show();
        /**
         * mPresenter.signOff();
         Intent intent = new Intent(this, LoginActivityImpl.class);
         intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
         | Intent.FLAG_ACTIVITY_NEW_TASK
         | Intent.FLAG_ACTIVITY_CLEAR_TASK);
         startActivity(intent);
         */
    }

    @Override
    public void userUpdate(User user) {
        mUser = user;
        application.setmUser(user);
        Snackbar.make(this.mainContent, user.toString(), Snackbar.LENGTH_LONG).show();
    }
}

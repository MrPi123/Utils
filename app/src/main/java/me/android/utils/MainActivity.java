package me.android.utils;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import me.android.utils.ui.BaseActivity;
import me.android.utils.utils.Utils;


public class MainActivity extends BaseActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void initUI() {
        View view = findViewById(R.id.statusHeaderView);
//        transparentStatusBar(view);
        Utils.getInstance()
                .setStatusBarTranslucent(this,R.color.primary)
                .setStatusBarHeight(view,this)
                .setNavigationBarColor(this,R.color.primary,true);
    }
}

package com.wd.tech.ui.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.wd.tech.base.BaseActivity;
import com.wd.tech.techmoney.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean networkAvalible = isNetworkAvalible(this);
        noNetwork(networkAvalible);
    }

    @Override
    protected void initData() {
        showProgess();
    }

    @Override
    protected int initView() {
        return R.layout.activity_main;
    }
}

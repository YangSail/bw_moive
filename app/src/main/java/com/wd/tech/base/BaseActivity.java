package com.wd.tech.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.wd.tech.techmoney.R;

/**
 * @author
 * @date 2018.11.29
 * GitHub：
 * name:杨志凡
 */
public abstract class BaseActivity extends AppCompatActivity {
    private FrameLayout connect;
    private View inflate;
    private RelativeLayout progress;
    private RelativeLayout nonetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ImmersionBar.with(this).init();
        connect = findViewById(R.id.connect);
        progress = findViewById(R.id.progress);
        nonetwork = findViewById(R.id.nonetwork_relative);
        int id = initView();
        inflate = LinearLayout.inflate(this, id, null);
        connect.addView(inflate);
        initView();
        initData();
    }

    //逻辑代码
    protected abstract void initData();

    //加载布局
    protected abstract int initView();

    //是否有网后的操作
    public void noNetwork(boolean isnonet) {
        if (!isnonet) {
            inflate.setVisibility(View.GONE);
            progress.setVisibility(View.GONE);
            nonetwork.setVisibility(View.VISIBLE);
            return;
        }
    }

    //显示progess
    public void showProgess() {
        inflate.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        nonetwork.setVisibility(View.GONE);
    }

    //隐藏progess
    public void heidProgess() {
        inflate.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
        nonetwork.setVisibility(View.GONE);
    }


    //判断是否有网 有返回true 没有返回false
    public boolean isNetworkAvalible(Context context) {
        // 获得网络状态管理器  
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        } else {
            // 建立网络数组  
            NetworkInfo[] net_info = connectivityManager.getAllNetworkInfo();
            if (net_info != null) {
                for (int i = 0; i < net_info.length; i++) {
            // 判断获得的网络状态是否是处于连接状态  
                    if (net_info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

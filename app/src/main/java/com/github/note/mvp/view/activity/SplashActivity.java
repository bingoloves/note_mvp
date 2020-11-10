package com.github.note.mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.github.base.base.AbsBaseUIActivity;
import com.github.base.di.component.AppComponent;
import com.github.base.integration.AppManager;
import com.github.base.utils.rxjava.RxJavaUtils;
import com.github.note.R;
import com.github.note.mvp.contract.SplashContract;
import com.github.note.di.component.DaggerSplashComponent;
import com.github.note.mvp.presenter.SplashPresenter;

/**
 * Created by bingo on 2020/11/6.
 */

public class SplashActivity extends AbsBaseUIActivity<SplashPresenter> implements SplashContract.View{

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        //如找不到该类,请编译一下项目
        DaggerSplashComponent
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mCommonToolbar.setVisibility(View.GONE);
        setStatusBarWhiteFontTrans();
        RxJavaUtils.delay(1, aLong -> gotoNext());
    }

    private void gotoNext() {
        AppManager.getAppManager().startActivity(MainActivity.class);
        AppManager.getAppManager().stopActivity(SplashActivity.this);
    }
}

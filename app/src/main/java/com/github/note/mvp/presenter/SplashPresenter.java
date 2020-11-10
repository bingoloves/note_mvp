package com.github.note.mvp.presenter;

import android.app.Application;

import com.github.base.di.scope.ActivityScope;
import com.github.base.mvp.CrazyBasePresenter;
import com.github.note.mvp.contract.SplashContract;

import javax.inject.Inject;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;


/**
 * ================================================
 *
 * @Author: crazyandcoder
 * @Version: 1.0
 * ================================================
 */
@ActivityScope
public class SplashPresenter extends CrazyBasePresenter<SplashContract.Model, SplashContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;

    @Inject
    public SplashPresenter(SplashContract.Model model, SplashContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mApplication = null;
    }
}

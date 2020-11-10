package com.github.note.mvp.model;

import android.app.Application;

import com.github.base.di.scope.ActivityScope;
import com.github.base.integration.IRepositoryManager;
import com.github.base.mvp.CrazyBaseModel;
import com.github.note.mvp.contract.SplashContract;
import com.google.gson.Gson;
import javax.inject.Inject;


/**
 * ================================================
 *
 * @Author: crazyandcoder
 * @Version: 1.0
 * ================================================
 */
@ActivityScope
public class SplashModel extends CrazyBaseModel implements SplashContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public SplashModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}
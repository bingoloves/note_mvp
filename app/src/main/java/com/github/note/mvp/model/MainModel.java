package com.github.note.mvp.model;

import android.app.Application;

import com.github.base.di.scope.ActivityScope;
import com.github.base.integration.IRepositoryManager;
import com.github.base.mvp.CrazyBaseModel;
import com.github.note.mvp.contract.MainContract;
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
public class MainModel extends CrazyBaseModel implements MainContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}
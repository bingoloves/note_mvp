package com.github.note.mvp.model;

import android.app.Application;

import com.github.base.di.scope.FragmentScope;
import com.github.base.integration.IRepositoryManager;
import com.github.base.mvp.CrazyBaseModel;
import com.github.note.api.CommonApiService;
import com.github.note.mvp.contract.MyContract;
import com.google.gson.Gson;
import javax.inject.Inject;
import io.reactivex.Observable;


/**
 * ================================================
 *
 * @Author: crazyandcoder
 * @Version: 1.0
 * ================================================
 */
@FragmentScope
public class MyModel extends CrazyBaseModel implements MyContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public MyModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

//    @Override
//    public Observable<BaseResult<UpdateCoreSuper>> checkUpdate() {
//        return mRepositoryManager.obtainRetrofitService(CommonApiService.class).checkUpdate(
//                "com.crazyandcoder.top.university",
//                AppUtils.getVersionCode()
//        );
//    }
}
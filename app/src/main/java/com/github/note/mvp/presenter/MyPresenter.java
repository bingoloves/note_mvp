package com.github.note.mvp.presenter;

import android.app.Application;

import com.github.base.di.scope.FragmentScope;
import com.github.base.mvp.CrazyBasePresenter;
import com.github.note.mvp.contract.MyContract;

import javax.inject.Inject;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

/**
 * ================================================
 *
 * @Author: crazyandcoder
 * @Version: 1.0
 * ================================================
 */
@FragmentScope
public class MyPresenter extends CrazyBasePresenter<MyContract.Model, MyContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;

    @Inject
    public MyPresenter(MyContract.Model model, MyContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mApplication = null;
    }

    public void checkUpdate() {
//        httpRequestDetail(true, mModel.checkUpdate(), new OnRequestCallback<UpdateCoreSuper>(mApplication, mErrorHandler) {
//            @Override
//            public void onSuccess(UpdateCoreSuper update, BaseResult objResult) {
//                mRootView.hasUpdate(update);
//            }
//
//            @Override
//            public void onFailure(int status, String resultMsg) {
//                super.onFailure(status, resultMsg);
//                mRootView.updateError();
//            }
//        });
    }
}

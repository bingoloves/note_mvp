package com.github.note.mvp.presenter;

import android.app.Application;

import com.github.base.di.scope.FragmentScope;
import com.github.base.mvp.CrazyBasePresenter;
import com.github.note.mvp.contract.HomeContract;

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
public class HomePresenter extends CrazyBasePresenter<HomeContract.Model, HomeContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;

    @Inject
    public HomePresenter(HomeContract.Model model, HomeContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mApplication = null;
    }

    /**
     * 获取school列表
     *
     * @param schoolListReq
     */
//    public void getSchoolHotList(SchoolHotListReq schoolListReq) {
//        httpRequestDetail(true, mModel.getSchoolHotList(schoolListReq), new OnRequestCallback<BasePageResult<TopSchoolResp>>(mApplication, mErrorHandler) {
//            @Override
//            public void onSuccess(BasePageResult<TopSchoolResp> school, BaseResult objResult) {
//                mRootView.schoolListSuccess(school);
//            }
//
//            @Override
//            public void onFailure(int status, String resultMsg) {
//                super.onFailure(status, resultMsg);
//                mRootView.schoolListFailure();
//            }
//        });
//    }

    /**
     * 获取school列表
     *
     * @param schoolListReq
     */
//    public void getSchoolList(SchoolListReq schoolListReq) {
//        httpRequestDetail(true, mModel.getSchoolList(schoolListReq), new OnRequestCallback<BasePageResult<TopSchoolResp>>(mApplication, mErrorHandler) {
//            @Override
//            public void onSuccess(BasePageResult<TopSchoolResp> school, BaseResult objResult) {
//                mRootView.schoolListSuccess(school);
//            }
//
//            @Override
//            public void onFailure(int status, String resultMsg) {
//                super.onFailure(status, resultMsg);
//                mRootView.schoolListFailure();
//            }
//        });
//    }

    /**
     * 热门专业列表
     * @param professionHotListReq
     */
//    public void getProfessionHotList(ProfessionHotListReq professionHotListReq) {
//        httpRequestDetail(true, mModel.getProfessionHotList(professionHotListReq), new OnRequestCallback<BasePageResult<ProfessionHotListResp>>(mApplication, mErrorHandler) {
//            @Override
//            public void onSuccess(BasePageResult<ProfessionHotListResp> prfession, BaseResult objResult) {
//                mRootView.ProfessionHotListSuccess(prfession);
//            }
//
//            @Override
//            public void onFailure(int status, String resultMsg) {
//                super.onFailure(status, resultMsg);
//                mRootView.ProfessionHotListFailure();
//            }
//        });
//    }
}

package com.github.note.mvp.model;

import android.app.Application;

import com.github.base.di.scope.FragmentScope;
import com.github.base.integration.IRepositoryManager;
import com.github.base.mvp.CrazyBaseModel;
import com.github.note.mvp.contract.HomeContract;
import com.google.gson.Gson;

import javax.inject.Inject;

/**
 * ================================================
 *
 * @Author: crazyandcoder
 * @Version: 1.0
 * ================================================
 */
@FragmentScope
public class HomeModel extends CrazyBaseModel implements HomeContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public HomeModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

//    @Override
//    public Observable<BasePageResult<TopSchoolResp>> getSchoolList(SchoolListReq schoolListReq) {
//        return mRepositoryManager.obtainRetrofitService(SchoolApiService.class).getSchoolList(schoolListReq.getF211(),
//                schoolListReq.getF985(),
//                schoolListReq.getKeyword(),
//                schoolListReq.getProvinceId(),
//                schoolListReq.getType(),
//                schoolListReq.getSchoolType(),
//                schoolListReq.getPageNo(),
//                schoolListReq.getPageSize());
//    }
//
//    @Override
//    public Observable<BasePageResult<ProfessionHotListResp>> getProfessionHotList(ProfessionHotListReq professionHotListReq) {
//        return mRepositoryManager.obtainRetrofitService(ProfessionApiService.class).getProfessionHotList(
//                professionHotListReq.getLevel1(),
//                professionHotListReq.getPageNo(),
//                professionHotListReq.getPageSize());
//    }
//
//    @Override
//    public Observable<BasePageResult<TopSchoolResp>> getSchoolHotList(SchoolHotListReq schoolListReq) {
//        return mRepositoryManager.obtainRetrofitService(SchoolApiService.class).getSchoolHotList(
//                schoolListReq.getProvinceId(),
//                schoolListReq.getType(),
//                schoolListReq.getSchoolType(),
//                schoolListReq.getPageNo(),
//                schoolListReq.getPageSize());
//    }
}
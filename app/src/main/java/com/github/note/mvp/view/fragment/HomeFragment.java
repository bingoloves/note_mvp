package com.github.note.mvp.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.base.base.AbsBaseUIActivity;
import com.github.base.base.AbsCrazyBaseFragment;
import com.github.base.di.component.AppComponent;
import com.github.base.widget.loading.LoadingDialog;
import com.github.note.R;
import com.github.note.di.component.DaggerHomeComponent;
import com.github.note.mvp.contract.HomeContract;
import com.github.note.mvp.presenter.HomePresenter;

import javax.inject.Inject;
import butterknife.BindView;


/**
 * ================================================
 *
 * @Author: crazyandcoder
 * @Version: 1.0
 * ================================================
 */
public class HomeFragment extends AbsCrazyBaseFragment<HomePresenter> implements HomeContract.View, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private int currentPage = 1;
    private boolean isRefresh = true;
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        //如找不到该类,请编译一下项目
        DaggerHomeComponent
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initLayout(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        onStartLoadData();
//        banner.setAdapter(new HomeBannerImageAdapter(BannerInfoResp.getTestData()));
//        banner.isAutoLoop(false);
//        banner.removeIndicator();
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#3496FA"));
        swipeRefreshLayout.setOnRefreshListener(this);
//        linearLayoutManager = new LinearLayoutManager(getActivity());
//        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
//        schoolListRecycler.setLayoutManager(linearLayoutManager);
//        schoolListRecycler.setHasFixedSize(true);
//        schoolListRecycler.setNestedScrollingEnabled(false);
//        schoolListRecycler.setFocusableInTouchMode(false);
//        schoolListRecycler.setItemAnimator(new DefaultItemAnimator());
//        schoolListRecycler.setAdapter(schoolListAdapter);

        //跳转详情
//        schoolListAdapter.setOnItemClickListener(new AbsCrazyBaseAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(AbsCrazyBaseAdapter adapter, View view, int position) {
//                if (schoolListAdapter != null && schoolListAdapter.getData() != null && position < schoolListAdapter.getData().size()) {
//                    TopSchoolResp itemBean = schoolListAdapter.getData().get(position);
//                    if (itemBean != null) {
//                        Intent intent = new Intent();
//                        intent.putExtra(Constant.Page.PAGE_KEY, itemBean.getSchoolId());
//                        intent.setClass(getActivity(), SchoolDetailActivity.class);
//                        AppManager.getAppManager().startActivity(intent);
//                    }
//                }
//            }
//        });


        //高校列表
//        catagorySchoolRl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AppManager.getAppManager().startActivity(SchoolListActivity.class);
//            }
//        });

        //专业列表
//        catagorySpecialRl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AppManager.getAppManager().startActivity(ProfessionListActivity.class);
//            }
//        });

        //更多的热门专业
//        moreHotProfessionRl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AppManager.getAppManager().startActivity(ProfessionHotListActivity.class);
//            }
//        });

        //更多的热门专业
//        moreHotSchoolRl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), SchoolListActivity.class);
//                AppManager.getAppManager().startActivity(intent);
//            }
//        });

    }


    /**
     * 下拉刷新
     */
    private void onStartLoadData() {
        currentPage = 1;
        isRefresh = true;
        //这里的作用是防止下拉刷新的时候还可以上拉加载
        //schoolListAdapter.setEnableLoadMore(false);
        onRequestListData();
    }


    /**
     * 发起请求
     */
    private void onRequestListData() {
        //热门高校列表请求
//        if (schoolListReq != null) {
//            schoolListReq.setSchoolType("6000");
//            schoolListReq.setPageSize("" + Constant.Page.PageSize);
//            schoolListReq.setPageNo("" + currentPage);
//            mPresenter.getSchoolHotList(schoolListReq);
//        }

        //热门专业列表
//        if (professionHotListReq != null) {
//            professionHotListReq.setPageNo("1");
//            professionHotListReq.setLevel1("1");
//            professionHotListReq.setPageSize("" + Constant.Page.PageSize);
//            mPresenter.getProfessionHotList(professionHotListReq);
//        }
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public Context getLayoutManagerContext() {
        return getActivity();
    }

//    @Override
//    public void schoolListSuccess(BasePageResult<TopSchoolResp> result) {
//        schoolListAdapter.setNewData(result.getRecords());
//        schoolListRecycler.setAdapter(schoolListAdapter);
//        schoolListAdapter.setEnableLoadMore(false);
//        hideLoading();
//    }

    @Override
    public void schoolListFailure() {
        //schoolSwipeLayout.setRefreshing(false);
        //schoolListAdapter.setEnableLoadMore(false);
        hideLoading();
    }

//    @Override
//    public void ProfessionHotListSuccess(BasePageResult<ProfessionHotListResp> prfession) {
//        hideLoading();
//        RecommendProfessionHotListAdapter itemAdapter = new RecommendProfessionHotListAdapter(prfession.getRecords());
//        professionBanner.setAdapter(itemAdapter);
//        professionBanner.removeIndicator();
//        itemAdapter.setOnItemClickListener(new RecommendProfessionHotListAdapter.OnItemClickListener() {
//            @Override
//            public void onClick(int position, ProfessionHotListResp resp) {
//                Intent intent = new Intent(getActivity(), ProfessionDetailInfoActivity.class);
//                intent.putExtra(Constant.Page.PAGE_KEY, resp.getSpecialId());
//                AppManager.getAppManager().startActivity(intent);
//            }
//        });
//    }

    @Override
    public void ProfessionHotListFailure() {
        hideLoading();
    }

    @Override
    public void onRefresh() {
        //onStartLoadData();
        if (getActivity() instanceof AbsBaseUIActivity){
            ((AbsBaseUIActivity) getActivity()).showLoading(() -> swipeRefreshLayout.setRefreshing(false));
        }
    }
}

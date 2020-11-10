package com.github.note.mvp.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.base.base.AbsCrazyBaseFragment;
import com.github.base.di.component.AppComponent;
import com.github.note.R;
import com.github.note.di.component.DaggerMyComponent;
import com.github.note.mvp.contract.MyContract;
import com.github.note.mvp.presenter.MyPresenter;


/**
 * ================================================
 *
 * @Author: crazyandcoder
 * @Version: 1.0
 * ================================================
 */
public class MyFragment extends AbsCrazyBaseFragment<MyPresenter> implements MyContract.View {

    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        //如找不到该类,请编译一下项目
        DaggerMyComponent
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);

    }

    @Override
    public View initLayout(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {


//        infoRl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!UserManager.getInstance().login()) {
//                    startActivity(new Intent(getActivity(), LoginActivity.class));
//                }
//            }
//        });


//        favL.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!UserManager.getInstance().login()) {
//                    startActivity(new Intent(getActivity(), LoginActivity.class));
//                }
//            }
//        });

//        nameL.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!UserManager.getInstance().login()) {
//                    startActivity(new Intent(getActivity(), LoginActivity.class));
//                }
//            }
//        });


//        aboutL.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getActivity(), AboutActivity.class));
//            }
//        });


//        feedbackL.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getActivity(), AdviceActivity.class));
//            }
//        });


//        settingL.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getActivity(), SettingActivity.class));
//            }
//        });


//        updateL.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mPresenter.checkUpdate();
//            }
//        });


    }

    @Override
    public void onResume() {
        super.onResume();
//        if (UserManager.getInstance().login()) {
//            nameTv.setText("你好," + UserManager.getInstance().getUserName());
//        } else {
//            nameTv.setText("登录");
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

//    @Override
//    public void hasUpdate(UpdateCoreSuper update) {
//        UpdateCoreSuper mUpdateApp = update;
//        String updateLog = mUpdateApp.getUpdateDesc();
//        new CommonAlertDialog.Builder().with(getActivity())
//                .setTitle("更新提示")
//                .setContent(updateLog)
//                .setLeftText("取消")
//                .setRightText("更新")
//                .setOnDialogListener(new ICrazyBaseDialogListener() {
//                    @Override
//                    public void cancel() {
//                    }
//
//                    @Override
//                    public void confirm(Object o) {
//                        ToastUtils.showToast(getContext(), "正在后台下载中...");
//
//                    }
//                }).build().show();
//    }

    @Override
    public void updateError() {

    }
}

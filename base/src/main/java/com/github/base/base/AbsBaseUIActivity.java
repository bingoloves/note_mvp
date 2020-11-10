package com.github.base.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.github.base.R;
import com.github.base.mvp.ICrazyPresenter;
import com.github.base.utils.rxjava.RxJavaUtils;
import com.github.base.widget.loading.LoadingDialog;
import com.github.base.widget.toast.ToastUtils;
import com.github.base.widget.toolbar.CustomToolbar;
import com.gyf.immersionbar.ImmersionBar;
import io.reactivex.functions.Consumer;

/**
 *
 */
public abstract class AbsBaseUIActivity<P extends ICrazyPresenter> extends AbsCrazyBaseActivity<P> implements IBaseUIView {

    protected CustomToolbar mCommonToolbar;
    protected LinearLayout mAxBaseContentLl;
    protected LinearLayout mAxBaseParentLl;
    protected ImmersionBar mImmersionBar;
    private LoadingDialog mLoadingDialog;

    @Override
    public int initLayout(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_base_ui;
    }

    @Override
    public void initView(View mRootView) {
        mCommonToolbar = (CustomToolbar) mRootView.findViewById(R.id.base_toolbar);
        mAxBaseContentLl = (LinearLayout) mRootView.findViewById(R.id.base_content_ll);
        mAxBaseParentLl = (LinearLayout) mRootView.findViewById(R.id.base_parent_ll);

        getLayoutInflater().inflate(getContentViewId(), mAxBaseContentLl, true);

        if (getBackgroundRes() != 0) {
            mAxBaseContentLl.setBackgroundResource(getBackgroundRes());
        }

        if (showToolbar()) {
            mCommonToolbar.setVisibility(View.VISIBLE);
        } else {
            mCommonToolbar.setVisibility(View.GONE);
        }
    }

    protected void setTitle(String title) {
        mCommonToolbar.setCenterTitle(title);
    }

    protected void setTitle(String title, String color) {
        mCommonToolbar.setCenterTitle(title, color);
    }

    @Override
    public void setContentView(int layoutResID) {
        if (layoutResID != 0) {
            //如果initView返回0,框架则不会调用setContentView()
            View mRootView = (View) getLayoutInflater().inflate(layoutResID, null);
            setContentView(mRootView);
            initView(mRootView);
            onInitView();
            //初始化沉浸式
            initImmersionBar();
        }
    }

    /**
     * 初始化沉浸式
     * Init immersion bar.
     */
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.titleBar(mCommonToolbar).fitsSystemWindows(true).statusBarColor(android.R.color.white).autoDarkModeEnable(true)
                .navigationBarColor("#ffffff").navigationBarDarkIcon(true).init();
    }

    /**
     * 透明状态栏
     */
    protected void setStatusBarTrans() {
        if (mImmersionBar == null) {
            return;
        }
        mImmersionBar.transparentStatusBar().init();
    }

    /**
     * 透明状态栏 状态栏文字为白色
     */
    protected void setStatusBarWhiteFontTrans() {
        if (mImmersionBar == null) {
            return;
        }
        mImmersionBar.transparentStatusBar().statusBarDarkFont(false).init();
    }


    public void setBackRes(@IdRes int resId, View.OnClickListener onClickListener) {
        mCommonToolbar.setLeftImage(resId, onClickListener);
    }

    @Override
    public void onInitView() {


    }

    @Override
    public boolean showToolbar() {
        return true;
    }


    @Override
    public void setAppContentBackground(int res) {
        if (mAxBaseParentLl != null && res != 0) {
            mAxBaseParentLl.setBackgroundResource(res);
        }
    }

    @Override
    public void setAppNavBackGround(int res) {
        if (mCommonToolbar != null && res != 0) {
            mCommonToolbar.setBackgroundResource(res);
        }
    }

    @Override
    public int getBackgroundRes() {
        return 0;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void onNavLeftClick() {
        onBackPressed();
    }

    @Override
    public View getLoadView() {
        return mAxBaseContentLl;
    }

    @Override
    public void onViewReload() {

    }

    @Override
    public void showLoadSirView(String status) {
    }

    /**
     * 自定义错误，加载，识别页面数据
     *
     * @param context
     * @param view
     * @param status
     */
    @Override
    public void onShowTransport(Context context, View view, String status) {

    }


    @Override
    public void showLoading() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new LoadingDialog(this);
        }
        mLoadingDialog.showLoadingDialog(true);
    }

    public void showLoading(LoadingDialog.OnDismissListener onDismissListener) {
        if (mLoadingDialog == null) {
            mLoadingDialog = new LoadingDialog(this);
        }
        mLoadingDialog.showLoadingDialog(true);
        mLoadingDialog.setOnDismissListener(onDismissListener);
    }
    @Override
    public void hideLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowLoading()) {
            RxJavaUtils.delay(0.3f, new Consumer<Long>() {
                @Override
                public void accept(Long aLong) throws Exception {
                    mLoadingDialog.removeLoadingDialog();
                }
            });
        }
    }

    @Override
    public void showMessage(@NonNull String message) {
        ToastUtils.showToast(this, message);
    }


    //处理后退键的情况
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.finish();
            overridePendingTransition(R.anim.slide_in_left,
                    R.anim.slide_out_right);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(View headView, @IdRes int viewId) {
        View view = headView.findViewById(viewId);
        return (T) view;
    }

}

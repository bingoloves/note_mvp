package com.github.base.base;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.github.base.mvp.ICrazyView;

/**
 * @ClassName: IAxBaseUIView
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/6/16 10:52 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/6/16 10:52 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface IBaseUIView extends ICrazyView {

    void initView(View mRootView);

    int getContentViewId();

    void onInitView();

    boolean showToolbar();

    int getBackgroundRes();

    void setAppContentBackground(int res);

    void setAppNavBackGround(int res);

    void onNavLeftClick();

    Activity getActivity();

    View getLoadView();

    void showLoadSirView(String status);

    void onShowTransport(Context context, View view, String status);

    void onViewReload();

}

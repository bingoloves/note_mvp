package com.github.base.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.base.utils.Injector;

public abstract class BaseFragment extends Fragment {

    protected View mRoot;
    /**
     * 是否执行了lazyLoad方法
     */
    private boolean isLazyLoaded = false;
    /**
     * 是否创建了View
     */
    private boolean isCreateView;
    protected Activity activity;
    protected Context mContext;
    protected LayoutInflater inflater;
    protected ViewGroup container;
    protected Bundle savedInstanceState;
    /**
     * 当从另一个activity回到fragment所在的activity
     * 当fragment回调onResume方法的时候，可以通过这个变量判断fragment是否可见，来决定是否要刷新数据
     */
    public boolean isVisible;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        activity = (Activity) context;
    }

    //====================================针对ViewPager嵌套 ↓=======================================
    /*
     * 此方法在viewpager嵌套fragment时会回调
     * 查看FragmentPagerAdapter源码中instantiateItem和setPrimaryItem会调用此方法
     * 在所有生命周期方法前调用
     * 这个基类适用于在viewpager嵌套少量的fragment页面
     * 该方法是第一个回调，可以将数据放在这里处理（viewpager默认会预加载一个页面）
     * 只在fragment可见时加载数据，加快响应速度
     * */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            onVisible();
        } else {
            onInvisible();
        }
    }
    //====================================针对ViewPager嵌套 ↑=======================================
    /**
     * 在Fragment第一次可见加载以后，每次Fragment滑动/切换当前可见的时候会回调这个方法，
     * 子类可以重写这个方法做数据刷新操作
     */
    public void refreshLoad(){}
    /**
     *  因为Fragment是缓存在内存中，所以可以保存mRoot ，防止view的重复加载
     *  与FragmentPagerAdapter 中destroyItem方法取消调用父类的效果是一样的，可以任选一种做法 推荐第二种
     */

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if( mRoot == null ){
            mRoot = inflater.inflate(getContentView(), container, false);
            this.inflater = inflater;
            this.container = container;
            this.savedInstanceState = savedInstanceState;
            isCreateView = true;
            Injector.inject(this);
            initView();
            initLazyLoad();
        }
        return mRoot;
    }

    /**
     * 初始化懒加载 数据
     * getUserVisibleHint() 是否对用户可见 对通过 show/hide 方式 始终为true
     */
    private void initLazyLoad(){
        if (!isLazyLoaded && isCreateView && getUserVisibleHint()) {
            isLazyLoaded = true;
            lazyLoad();
        }
    }

    protected void onVisible() {
        isVisible = true;
        if(isLazyLoaded){
            refreshLoad();
        }
    }
    protected void onInvisible() {
        isVisible = false;
    }
    /**
     * 通过hide 和 show 显示或者隐藏Fragment时会触发此方法
     * @param hidden
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        isVisible = !hidden;
        if (!hidden && isLazyLoaded){
            refreshLoad();
        }
    }

    /**
     * 用于设置当前页面布局
     * @return
     */
    protected abstract int getContentView();

    /**
     * 用于初始化相关组件
     */
    protected abstract void initView();

    protected void toast(String msg){
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
    /**
     * fragment第一次创建的时候并且页面不可见的时候 会调此方法
     */
    protected abstract void lazyLoad();

    /**
     * 重定向 去除任务栈中其他Activity
     * 开了个新的栈，之前那个栈里的Activity都会被关掉
     */
    public void redirectNewActivity(Class<?> clz){
        Intent intent = new Intent(getContext(), clz);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        container = null;
        savedInstanceState = null;
        mRoot = null;
    }
}
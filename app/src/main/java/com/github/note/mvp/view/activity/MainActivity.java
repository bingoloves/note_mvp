package com.github.note.mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.github.base.base.AbsBaseUIActivity;
import com.github.base.di.component.AppComponent;
import com.github.base.widget.CustomViewPager;
import com.github.note.R;
import com.github.note.bean.TabEntity;
import com.github.note.di.component.DaggerMainComponent;
import com.github.note.mvp.contract.MainContract;
import com.github.note.mvp.presenter.MainPresenter;
import java.util.ArrayList;
import javax.inject.Inject;
import butterknife.BindView;

public class MainActivity extends AbsBaseUIActivity<MainPresenter> implements MainContract.View {

//    @Injector.OnClick({R.id.btn_click,R.id.btn_keyboard,R.id.btn_form})
//    public void clickEvent(View v){
//        switch (v.getId()){
//            case R.id.btn_click:
//                nineGridLayout.update(Arrays.asList(images));
//                break;
//            case R.id.btn_keyboard:
//                startActivity(new Intent(activity,KeyboardActivity.class));
//                break;
//            case R.id.btn_form:
//                startActivity(new Intent(activity,FormValidateActivity.class));
//                break;
//            default:
//                break;
//        }
//    }
//    @Injector.BindView(R.id.nineGridLayout)
//    NineGridLayout nineGridLayout;
    @BindView(R.id.viewPager)
    CustomViewPager mViewPager;
    @BindView(R.id.bottomTab)
    CommonTabLayout bottomTab;
    @Inject
    FragmentStatePagerAdapter mMainTabPageAdapter;

    private String[] mTitles = {"首页","我的"};
    private int[] mIconUnselectIds = {R.mipmap.nav_home_normal,  R.mipmap.nav_mine_normal};
    private int[] mIconSelectIds = {R.mipmap.nav_home_select, R.mipmap.nav_mine_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private String[] images = {
            "https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3363295869,2467511306&fm=26&gp=0.jpg",
            "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=151472226,3497652000&fm=26&gp=0.jpg",
            "https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1689053532,4230915864&fm=26&gp=0.jpg",
            "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1473836766,4030812874&fm=26&gp=0.jpg",
            "https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3892521478,1695688217&fm=26&gp=0.jpg"
    };

    @Override
    public FragmentManager getMainTabViewPagerSupportFragmentManager() {
        return getSupportFragmentManager();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        if (mTabEntities != null){
            for (int i = 0; i < mTitles.length; i++) {
                mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
            }
        }
        setTitle(mTitles[0]);
        mViewPager.setAdapter(mMainTabPageAdapter);
        bottomTab.setTabData(mTabEntities);
        bottomTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position,false);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomTab.setCurrentTab(position);
                setTitle(mTitles[position]);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}

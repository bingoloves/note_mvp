package com.github.note.di.module;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.base.di.scope.ActivityScope;
import com.github.note.mvp.contract.MainContract;
import com.github.note.mvp.model.MainModel;
import com.github.note.mvp.view.fragment.HomeFragment;
import com.github.note.mvp.view.fragment.MyFragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import java.util.List;


/**
 * ================================================
 *
 * @Author: crazyandcoder
 * @Version: 1.0
 * ================================================
 */
@Module
public abstract class MainModule {

    @Binds
    abstract MainContract.Model bindMainModel(MainModel model);

    @ActivityScope
    @Provides
    static List<Fragment> provideList() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(HomeFragment.newInstance());
        fragmentList.add(MyFragment.newInstance());
        return fragmentList;
    }

    @ActivityScope
    @Provides
    static FragmentManager provideFragmentManager(MainContract.View view) {
        return view.getMainTabViewPagerSupportFragmentManager();
    }

    @ActivityScope
    @Provides
    static FragmentStatePagerAdapter provideFragmentStatePagerAdapter(FragmentManager fragmentManager, List<Fragment> list) {
        BaseViewPagerAdapter bossMainTabViewPagerAdapter = new BaseViewPagerAdapter(fragmentManager, list);
        return bossMainTabViewPagerAdapter;
    }
    static class BaseViewPagerAdapter extends FragmentStatePagerAdapter {

        private List<Fragment> mFragments;

        public BaseViewPagerAdapter(FragmentManager fm, List<Fragment> fragments){
            super(fm);
            this.mFragments = fragments;
        }
        public BaseViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
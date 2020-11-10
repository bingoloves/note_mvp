package com.github.note.di.module;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.base.di.scope.FragmentScope;
import com.github.note.mvp.contract.HomeContract;
import com.github.note.mvp.model.HomeModel;

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
public abstract class HomeModule {

    @Binds
    abstract HomeContract.Model bindHomeModel(HomeModel model);

    @FragmentScope
    @Provides
    static RecyclerView.LayoutManager provideLayoutManager(HomeContract.View view) {
        return new LinearLayoutManager(view.getLayoutManagerContext());
    }

//    @FragmentScope
//    @Provides
//    static List<TopSchoolResp> provideList() {
//        return new ArrayList<>();
//    }


//    @FragmentScope
//    @Provides
//    static RecyclerView.Adapter provideRecommendSchoolListAdapter(List<TopSchoolResp> list) {
//        return new RecommendSchoolListAdapter(list);
//    }



}
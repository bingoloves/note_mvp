package com.github.note.di.component;

import com.github.base.di.component.AppComponent;
import com.github.base.di.scope.FragmentScope;
import com.github.note.di.module.HomeModule;
import com.github.note.mvp.contract.HomeContract;
import com.github.note.mvp.view.fragment.HomeFragment;

import dagger.BindsInstance;
import dagger.Component;

/**
 * ================================================
 *
 * @Author: crazyandcoder
 * @Version: 1.0
 * ================================================
 */
@FragmentScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {

    void inject(HomeFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder view(HomeContract.View view);

        Builder appComponent(AppComponent appComponent);

        HomeComponent build();
    }
}
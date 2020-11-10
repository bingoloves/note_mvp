package com.github.note.di.component;

import com.github.base.di.component.AppComponent;
import com.github.base.di.scope.ActivityScope;
import com.github.note.mvp.contract.SplashContract;
import com.github.note.di.module.SplashModule;
import com.github.note.mvp.view.activity.SplashActivity;

import dagger.BindsInstance;
import dagger.Component;

/**
 * ================================================
 *
 * @Author: crazyandcoder
 * @Version: 1.0
 * ================================================
 */
@ActivityScope
@Component(modules = SplashModule.class, dependencies = AppComponent.class)
public interface SplashComponent {

    void inject(SplashActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder view(SplashContract.View view);
        Builder appComponent(AppComponent appComponent);
        SplashComponent build();
    }
}
package com.github.note.di.component;

import com.github.base.di.component.AppComponent;
import com.github.base.di.scope.ActivityScope;
import com.github.note.di.module.MainModule;
import com.github.note.mvp.contract.MainContract;
import com.github.note.mvp.view.activity.MainActivity;

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
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {

    void inject(MainActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder view(MainContract.View view);

        Builder appComponent(AppComponent appComponent);

        MainComponent build();
    }
}
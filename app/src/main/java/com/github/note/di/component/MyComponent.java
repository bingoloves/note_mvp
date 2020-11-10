package com.github.note.di.component;

import com.github.base.di.component.AppComponent;
import com.github.base.di.scope.FragmentScope;
import com.github.note.di.module.MyModule;
import com.github.note.mvp.contract.MyContract;
import com.github.note.mvp.view.fragment.MyFragment;

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
@Component(modules = MyModule.class, dependencies = AppComponent.class)
public interface MyComponent {

    void inject(MyFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder view(MyContract.View view);

        Builder appComponent(AppComponent appComponent);

        MyComponent build();
    }
}
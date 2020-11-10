package com.github.note.di.module;


import com.github.note.mvp.contract.MyContract;
import com.github.note.mvp.model.MyModel;
import dagger.Binds;
import dagger.Module;

/**
 * ================================================
 *
 * @Author: crazyandcoder
 * @Version: 1.0
 * ================================================
 */
@Module
public abstract class MyModule {

    @Binds
    abstract MyContract.Model bindMyModel(MyModel model);
}
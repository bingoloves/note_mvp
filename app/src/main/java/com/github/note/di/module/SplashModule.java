package com.github.note.di.module;

import com.github.note.mvp.contract.SplashContract;
import com.github.note.mvp.model.SplashModel;

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
public abstract class SplashModule {

    @Binds
    abstract SplashContract.Model bindSplashModel(SplashModel model);
}
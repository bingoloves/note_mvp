package com.github.note.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;

import com.github.base.delegate.AppLifecycles;
import com.github.note.BuildConfig;

import butterknife.ButterKnife;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;

/**
 * @ClassName: ApplicationLifecycleCallbacksImpl
 * @Description: application的生命周期初始化操作，进行第三方库的初始化操作
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/6/12 9:27 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/6/12 9:27 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ApplicationLifecycleCallbacksImpl implements AppLifecycles {

    @Override
    public void attachBaseContext(@NonNull Context base) {

    }

    @Override
    public void onCreate(@NonNull Application application) {
        if (BuildConfig.LOG_DEBUG) {
            ButterKnife.setDebug(true);
            RetrofitUrlManager.getInstance().setDebug(true);
        }
        MultiDex.install(application);
    }


    @Override
    public void onTerminate(@NonNull Application application) {

    }
}

package com.github.base.http;


import android.app.Application;

import com.github.base.bean.BaseResult;
import com.github.base.widget.toast.ToastUtils;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;


/**
 * @ClassName: OnRequestCallback
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/6/22 2:42 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/6/22 2:42 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class OnRequestCallback<T> extends ErrorHandleSubscriber<BaseResult<T>> {


    private Application application;

    public abstract void onSuccess(T t, BaseResult objResult);

    public void onFailure(int code, String resultMsg) {
        if (application != null) {
            ToastUtils.showToast(application, "" + resultMsg);
        }
    }

    @Override
    public void onError(Throwable t) {
        super.onError(t);
    }

    public OnRequestCallback(Application application, RxErrorHandler rxErrorHandler) {
        super(rxErrorHandler);
        this.application = application;
    }


    @Override
    public void onNext(BaseResult<T> tBaseResult) {
        switch (tBaseResult.getCode()) {
            case 0:
                if (tBaseResult != null) {
                    onSuccess(tBaseResult.getData(), tBaseResult);
                } else {
                    onFailure(-503, "数据解析失败,BaseResult不可为null");
                }
                break;

            default:
                if (tBaseResult != null) {
                    onFailure(tBaseResult.getCode(), tBaseResult.getMsg());
                } else {
                    onFailure(-504, "数据解析失败，BaseResult不可为null");
                }
                break;
        }
    }

}
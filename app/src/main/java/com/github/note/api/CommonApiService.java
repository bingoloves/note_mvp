package com.github.note.api;

import com.github.base.bean.BaseResult;
import com.github.note.bean.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CommonApiService {

    /**
     * @return
     */
    @GET("/crazyandcoder/update/info")
    Observable<BaseResult<User>> checkUpdate(@Query("pkg") String pkg,
                                             @Query("versionCode") int versionCode);


}

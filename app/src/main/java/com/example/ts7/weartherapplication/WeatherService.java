package com.example.ts7.weartherapplication;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @FileName WeatherService
 * @Description WeatherService Retrofit 定义所有网络的请求
 * @Author x925914554@gmail.com
 * @Company
 * @CreateDate 18-11-15
 * @LastModifyDate 18-11-15
 * @Since
 * @Version
 */
public interface WeatherService {

    /**
     * 获取指定城市的天气信息
     * @param key 开发者key
     * @param location 城市名称
     * @return 返回一个Observable类型 用于Rxjava的处理
     */
    @GET("s6/weather/now")
    Observable<WeatherEntity> getWeather(@Query("key") String key, @Query("location") String location);

}

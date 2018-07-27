package com.lokeshsoni.weatherradar.retrofit;

import com.lokeshsoni.weatherradar.model.WeatherForecastResult;
import com.lokeshsoni.weatherradar.model.WeatherResult;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IOpenWeatherMap {

    @GET("weather")
    Observable<WeatherResult>  getWeatherByLatLng(@Query("lat") String lat,
                                                  @Query("lon") String lon,
                                                  @Query("appid") String appid,
                                                  @Query("units") String units);
    @GET("forecast")
    Observable<WeatherForecastResult>  getForecastWeatherByLatLng(@Query("lat") String lat,
                                                                  @Query("lon") String lon,
                                                                  @Query("appid") String appid,
                                                                  @Query("units") String units);

}

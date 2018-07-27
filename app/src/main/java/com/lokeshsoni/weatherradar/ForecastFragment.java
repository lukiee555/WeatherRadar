package com.lokeshsoni.weatherradar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lokeshsoni.weatherradar.adapter.WeatherForecastAdapter;
import com.lokeshsoni.weatherradar.common.Common;
import com.lokeshsoni.weatherradar.model.WeatherForecastResult;
import com.lokeshsoni.weatherradar.retrofit.IOpenWeatherMap;
import com.lokeshsoni.weatherradar.retrofit.RetrofitClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {

    CompositeDisposable compositeDisposable;
    IOpenWeatherMap mService;

    TextView textViewCityName, textViewGeoCords;
    RecyclerView recyclerViewForecast;


    static  ForecastFragment instance;

    public static ForecastFragment getInstance() {
        if(instance == null)
            instance = new ForecastFragment();
        return instance;
    }


    public ForecastFragment() {
        compositeDisposable = new CompositeDisposable();
        Retrofit retrofit = RetrofitClient.getInstance();
        mService = retrofit.create(IOpenWeatherMap.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_forecast, container, false);

        textViewCityName = itemView.findViewById(R.id.textCityName);
        textViewGeoCords = itemView.findViewById(R.id.textGeoCords);
        recyclerViewForecast = itemView.findViewById(R.id.recyclerViewForecast);
        recyclerViewForecast.setHasFixedSize(true);
        recyclerViewForecast.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        getWeatherForecastInformation();
        return itemView;
    }

    private void getWeatherForecastInformation() {

        compositeDisposable.add(mService.getForecastWeatherByLatLng(String.valueOf(Common.curruntLocation.getLatitude()),
                String.valueOf(Common.curruntLocation.getLongitude()),
                Common.API_KEY,"metric")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherForecastResult>() {
                    @Override
                    public void accept(WeatherForecastResult weatherForecastResult) throws Exception {

                        displayForecastWeather(weatherForecastResult);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("ERROR",""+ throwable.getMessage());
                        Toast.makeText(getActivity(),"ERROR "+throwable.getMessage(),Toast.LENGTH_LONG).show();

                    }
                })

        );

    }

    private void displayForecastWeather(WeatherForecastResult weatherForecastResult) {

        textViewCityName.setText(new StringBuilder(weatherForecastResult.city.name));
        textViewGeoCords.setText(new StringBuilder(weatherForecastResult.city.coord.toString()));

        WeatherForecastAdapter weatherForecastAdapter = new WeatherForecastAdapter(getContext(),weatherForecastResult);
        recyclerViewForecast.setAdapter(weatherForecastAdapter);
    }

    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}

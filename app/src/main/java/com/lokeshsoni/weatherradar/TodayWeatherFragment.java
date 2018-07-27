package com.lokeshsoni.weatherradar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lokeshsoni.weatherradar.common.Common;
import com.lokeshsoni.weatherradar.model.WeatherResult;
import com.lokeshsoni.weatherradar.retrofit.IOpenWeatherMap;
import com.lokeshsoni.weatherradar.retrofit.RetrofitClient;
import com.squareup.picasso.Picasso;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class TodayWeatherFragment extends Fragment {

    ImageView imageViewWeather;
    TextView textViewCityName,textViewHumidity,textViewDescription,textViewTemperture, textViewPressure,textViewSunrise,textViewSunset,textViewWind,textViewDatTime,textViewGeoCords;
    LinearLayout weatherPanel;
    ProgressBar loading;

    CompositeDisposable compositeDisposable;
    IOpenWeatherMap mService;


    static  TodayWeatherFragment instance;

    public static TodayWeatherFragment getInstance() {
        if(instance == null)
            instance = new TodayWeatherFragment();
        return instance;
    }

    public TodayWeatherFragment() {
        compositeDisposable = new CompositeDisposable();
        Retrofit retrofit = RetrofitClient.getInstance();
        mService = retrofit.create(IOpenWeatherMap.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_today_weather, container, false);

        imageViewWeather = itemView.findViewById(R.id.imageWeather);
        textViewCityName = itemView.findViewById(R.id.textCityName);
        textViewHumidity = itemView.findViewById(R.id.textHumidity);
        textViewDescription = itemView.findViewById(R.id.textDescription);
        textViewPressure = itemView.findViewById(R.id.textPressure);
        textViewSunrise = itemView.findViewById(R.id.textSunrise);
        textViewSunset = itemView.findViewById(R.id.textSunset);
        textViewWind = itemView.findViewById(R.id.textWind);;
        textViewDatTime = itemView.findViewById(R.id.textDateTime);
        textViewGeoCords = itemView.findViewById(R.id.textGeoCords);
        textViewTemperture = itemView.findViewById(R.id.textTemprature);

        weatherPanel = itemView.findViewById(R.id.weatherPanel);
        loading = itemView.findViewById(R.id.loading);

        getWeatherInformation();


        return itemView;
    }

    private void getWeatherInformation() {

        compositeDisposable.add(mService.getWeatherByLatLng(String.valueOf(Common.curruntLocation.getLatitude()),
                String.valueOf(Common.curruntLocation.getLongitude()),
                Common.API_KEY,
                "metric")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherResult>() {
                    @Override
                    public void accept(WeatherResult weatherResult) throws Exception {

                        //Load Image
                        Picasso.get().load(new StringBuilder("https://openweathermap.org/img/w/01n.png")
                                     .append(weatherResult.getWeather().get(0).getIcon())
                                     .append(".png").toString()).placeholder(R.mipmap.ic_launcher_round).into(imageViewWeather);


                        //Load Information
                        textViewCityName.setText(weatherResult.getName());
                        textViewDescription.setText(new StringBuilder("Weather in ").append(weatherResult.getName()).toString());
                        textViewTemperture.setText(new StringBuilder(String.valueOf(weatherResult.getMain().getTemp())).append("°C").toString());
                        textViewDatTime.setText(Common.convertUnixToDate(weatherResult.getDt()));
                        textViewPressure.setText(new StringBuilder(String.valueOf(weatherResult.getMain().getPressure())).append(" hpa").toString());
                        textViewHumidity.setText(new StringBuilder(String.valueOf(weatherResult.getMain().getHumidity())).append(" %").toString());
                        textViewSunrise.setText(Common.convertUnixToHour(weatherResult.getSys().getSunrise()));
                        textViewSunset.setText(Common.convertUnixToHour(weatherResult.getSys().getSunset()));
                        textViewGeoCords.setText(new StringBuilder("").append(weatherResult.getCoord().toString()).toString());

                        //Display panel
                        weatherPanel.setVisibility(View.VISIBLE);
                        loading.setVisibility(View.GONE);


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(getActivity(),""+throwable.getMessage(),Toast.LENGTH_LONG).show();
                    }
                })

        );
    }

}

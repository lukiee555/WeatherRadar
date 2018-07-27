package com.lokeshsoni.weatherradar.common;

import android.location.Location;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {

    public static final String API_KEY = "2fc814fd5c465a4e647816a5370d1388";
    public static Location curruntLocation = null;

    public static String convertUnixToDate(long dt) {

        Date date = new Date(dt * 1000L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm dd EEE MM:yyyy");
        String formatted = simpleDateFormat.format(date);
        return formatted;
    }

    public static String convertUnixToHour(long sunrise) {

        Date date = new Date(sunrise * 1000L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm ");
        String formatted = simpleDateFormat.format(date);
        return formatted;

    }
}

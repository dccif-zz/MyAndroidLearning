package com.coolweather.android.gson;

/**
 * Created by heyujie on 2017/10/5.
 */

public class AQI {
    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }
}

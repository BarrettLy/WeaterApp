package com.example.ts7.weartherapplication;

public class Weather {

    @Override
    public String toString() {
        return "Weather{" +
                "weatherCityName='" + weatherCityName + '\'' +
                ", weatherState='" + weatherState + '\'' +
                ", weatherTemperature='" + weatherTemperature + '\'' +
                ", weatherDate='" + weatherDate + '\'' +
                '}';
    }

    public String getWeatherCityName() {
        return weatherCityName;
    }

    public void setWeatherCityName(String weatherCityName) {
        this.weatherCityName = weatherCityName;
    }

    public String getWeatherState() {
        return weatherState;
    }

    public void setWeatherState(String weatherState) {
        this.weatherState = weatherState;
    }

    public String getWeatherTemperature() {
        return weatherTemperature;
    }

    public void setWeatherTemperature(String weatherTemperature) {
        this.weatherTemperature = weatherTemperature;
    }

    public String getWeatherDate() {
        return weatherDate;
    }

    public void setWeatherDate(String weatherDate) {
        this.weatherDate = weatherDate;
    }


    public Weather(String weatherCityName, String weatherState, String weatherTemperature, String weatherDate) {
        this.weatherCityName = weatherCityName;
        this.weatherState = weatherState;
        this.weatherTemperature = weatherTemperature;
        this.weatherDate = weatherDate;
    }

    private String weatherCityName;       //城市名
    private String weatherState;          //天气状态
    private String weatherTemperature;    //天气温度
    private String weatherDate;           //日期
}

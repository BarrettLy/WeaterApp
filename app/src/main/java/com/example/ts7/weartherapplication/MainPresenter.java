package com.example.ts7.weartherapplication;

import android.os.Handler;
import android.os.Message;
import android.util.Log;


import java.util.ArrayList;

import static com.example.ts7.weartherapplication.MainModel.SHOW_CITY;

public class MainPresenter {

    public String TAG = "LY--MainPresenter";
    private ImainView imainView;
    private MainModel mainModel;
    private ArrayList<String> arrayList;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case SHOW_CITY:
                    CityEntity cityEntity = (CityEntity)msg.obj;
                    //Log.d(TAG, "handleMessage: "+cityEntity.toString());
                    for (int i=0;i<cityEntity.getHeWeather6().get(0).getBasic().size();i++){
                        String cityname = cityEntity.getHeWeather6().get(0).getBasic().get(i).getLocation();
                        //Log.d(TAG, "handleMessage: cityname: "+cityname);
                        arrayList.add(cityname);
                    }
                    imainView.setCityListResule(arrayList);
                    break;
                    default:
                        break;
            }
        }
    };

    public MainPresenter(ImainView imainView){
        mainModel = new MainModel();
        this.imainView = imainView;
    }

    public void setCityList(ArrayList<String> arrayList){
        Log.d(TAG, "setCityList: ");
        this.arrayList = arrayList;
        mainModel.getCity(handler);
    }


    public void saveCity(ArrayList<String> arrayList) {
        mainModel.saveCity(arrayList);
    }

    public void getSaveCity(WeatherAdapter handerAdapter, ArrayList<String> weathersshow) {
        mainModel.getSaveCity(handerAdapter,weathersshow);
    }
}

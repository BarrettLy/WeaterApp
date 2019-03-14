package com.example.ts7.weartherapplication;


import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.WindowManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * @FileName MainModel
 * @Description MainModel
 * @Author x925914554@gmail.com
 * @Company
 * @CreateDate 18-11-13
 * @LastModifyDate 18-11-13
 * @Since
 * @Version
 */

public class MainModel {

    public static final String TAG = "LY--MainModel";
    private static final String LYTAG = "LY--MainModel";

    private static final String uid = "ec1243a04b4340ce8573b6f0dc5c73d3";
    private static final String BASE_URI = "https://free-api.heweather.com/s6/weather/now?location=";
    private static final String CITY_URI = "https://search.heweather.net/top?group=world";
    private static ArrayList<String> arrayListCity;
    public MainModel(){

    }

    private String resultData = "";
    public WeatherEntity mWeatherEntity = new WeatherEntity();
    public CityEntity mCityEntity = new CityEntity();
    public static final int SHOW_RESPONSE=0;//用于更新操作
    public static final int SHOW_CITY = 1;//用于更新城市列表



    public void getAllCity(final Handler handler){
        Log.d(TAG, "getCity: ");
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = null;
                    try {
                        url = new URL(CITY_URI+"&number=20"+"&key="+uid);
                    }catch (MalformedURLException el){
                        el.printStackTrace();
                    }

                    connection = (HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);

                    InputStream in = connection.getInputStream();
                    //下面对获取的输入流进行读取
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line=bufferedReader.readLine()) !=null){
                        response.append(line);
                    }
                    String city = response.toString();
                    //Log.d(TAG, "run: "+city);
                    if (city != null){
                        Gson gson = new Gson();
                        //解析城市列表
                        mCityEntity = gson.fromJson(city,CityEntity.class);
                    }
                    Message message = new Message();
                    message.what = SHOW_CITY;
                    //将服务数据存放到Ｍｅｓｓａｇｅ中
                    message.obj = mCityEntity;
                    handler.sendMessage(message);
                   // Log.d(TAG, "message: "+mCityEntity.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (connection != null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    public void getOneCity(final String city,final Handler handler)  {

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;

                try{
                    URL url= null;
                    try {
                        url = new URL(BASE_URI+URLEncoder.encode(city)+"&key="+uid);
                    } catch (MalformedURLException e1) {
                        e1.printStackTrace();
                    }

                    connection=(HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);

                    InputStream in =connection.getInputStream();
                    //下面对获取到的输入流进行读取
                    BufferedReader bufr=new BufferedReader(new InputStreamReader(in));
                    StringBuilder response=new StringBuilder();
                    String line;
                    while((line=bufr.readLine())!=null){
                        //Log.d(LYTAG,"line -> "+line);
                        response.append(line);
                    }

                    //Log.d(LYTAG,"getData -> "+response.toString());
                    String wearhercity = response.toString();

                    if(wearhercity != null){

                        Gson gson = new Gson();
                        mWeatherEntity = gson.fromJson(wearhercity,WeatherEntity.class);
                        //Log.d(LYTAG,"GSON -> "+mWeatherEntity.toString());
                    }

                    Message message=new Message();
                    message.what=SHOW_RESPONSE;
                    //将服务器返回的数据存放到Message中
                    message.obj=mWeatherEntity;
                    handler.sendMessage(message);
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    if(connection!=null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    public void saveCity(ArrayList<String> arrayList) {
        FileEntity fileEntity = new FileEntity();
        try {
            fileEntity.write(arrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getSaveCity(WeatherAdapter weatherAdapter, ArrayList<String> weathersshow) {
        Log.d(TAG, "getSaveCity: ");
        ArrayList<String> saveCitylist = new ArrayList<>();
        FileEntity fileEntity = new FileEntity();
        try {
            saveCitylist = fileEntity.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = saveCitylist.iterator();
        while (iterator.hasNext()){
            String line = iterator.next();
            weathersshow.add(line);
            weatherAdapter.addItem(line);
        }
    }
}







/*
        try {
            url = new URL("http://www.baidu.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            Log.d(LYTAG,"MainModel GetData");
            connection = (HttpURLConnection) url.openConnection();

        } catch (IOException e) {
            e.printStackTrace();
        }
      try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        Log.d(LYTAG,"O My GOd");
       // connection.setConnectTimeout(8000);
        //connection.setReadTimeout(8000);
        //getInputStream（）方法获取服务器的返回的输入流，然后读取


        try {
            in = connection.getInputStream();
            //下面对获取到的输入流进行读取
            BufferedReader bufr = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            String line = null;
            while ((line = bufr.readLine()) !=null ){
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


      *//*  if(connection!=null){
            connection.disconnect();
        }*//*

    }*/






       /* try{
           // url = new URL(BASE_URI);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(url != null){
            try{
                HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
                InputStreamReader in = new InputStreamReader(urlconn.getInputStream());
                BufferedReader buffer = new BufferedReader(in);
                String inputLine = null;
                while (((inputLine  = buffer.readLine()) != null)){
                    resultData = inputLine+"\n";
                }
                in.close();
                urlconn.disconnect();
                if(resultData != null){
                    Log.d("LiuYang","getData");
                }else {
                    Log.d("LiuYang","null");
                }
            }catch (Exception e){
                e.printStackTrace();
            }


        }else {
            Log.d("LiuYang","urlnull");
        }



    }*/
/*    public void getData(String city) {

        final WeatherEntity weatherEntities = new WeatherEntity();

        mWeatherService.getWeather(uid, city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherEntity>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                        Log.d(TAG,"MainModel onSubscribe");

                    }

                    @Override
                    public void onNext(WeatherEntity weatherEntity) {
                        mWeatherEntity = weatherEntity;
                        Log.d(TAG,"MainModel onNext "+mWeatherEntity.toString());
                        //Log.d(TAG,"MainModel onNext"+weat )
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG,"MainModel onError");
                    }


                    @Override
                    public void onComplete() {
                        Log.d(TAG," MainModel onComplete");
                    }
                });
    }*/
package com.example.ts7.weartherapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    private static final String LYTAG = "LiuYang WeatherAdapter";

    private List<Weather> weatherList = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_weather);


        Log.d(LYTAG," MainActivity onCreate");
        initWeather();
        WeatherAdapter adapter = new WeatherAdapter(MainActivity.this,R.layout.item_weather,weatherList);
        ListView listView = (ListView) findViewById(R.id.list_weather_item);
        listView.setAdapter(adapter);

    }



    //初始化weather数据
    private void initWeather(){

        for(int i=0;i<1;i++){
            Weather one = new Weather("武汉","Cloudy","16 C","2018/11/15");
            weatherList.add(one);
            list.add(one.getWeatherCityName());

            Weather two = new Weather("吉林","Snow","0 C","2018/11/15");
            weatherList.add(two);
            list.add(two.getWeatherCityName());

            Weather three = new Weather("上海","Sunny","12 C","2018/11/15");
            weatherList.add(three);
            list.add(three.getWeatherCityName());

            Weather four = new Weather("天津","Rain","10 C","2018/11/15");
            weatherList.add(four);
            list.add(four.getWeatherCityName());

            Weather five = new Weather("沈阳","Rain","10 C","2018/11/15");
            weatherList.add(five);
            list.add(five.getWeatherCityName());

            Weather six = new Weather("南岗","Sunny","2 C","2018//11/15");
            weatherList.add(six);
            list.add(six.getWeatherCityName());

            Weather seven = new Weather("海淀","Sunny","3 C","2018/11/15");
            weatherList.add(seven);
            list.add(seven.getWeatherCityName());
        }

    }
}











/*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int arg1, long arg2) {

private LinearLayout linearLayout;
 linearLayout = (LinearLayout) view.findViewById(R.id.list_detail);
                if(listwearId == 0){
                    linearLayout.setVisibility(View.GONE);
                    listwearId++;
                }
                else{
                    linearLayout.setVisibility(View.VISIBLE);
                    listwearId--;
                }*/
                /*if (list.get((int) arg2).equals("WuHan")) {
                    Log.d(LYTAG,"You Click WuHan Weather");

                    linearLayout = (LinearLayout) findViewById(R.id.list_detail);
                    if(listwearId == 0){
                        linearLayout.setVisibility(View.GONE);
                        listwearId++;
                    }
                    else{
                        linearLayout.setVisibility(View.VISIBLE);
                        listwearId--;
                    }
                }
                if(list.get((int) arg2).equals("JiLin")){
                    linearLayout = (LinearLayout) findViewById(R.id.list_detail);
                    Log.d(LYTAG,"You Click JiLin Weather");
                    if(listwearId == 0){
                        linearLayout.setVisibility(View.GONE);
                        listwearId++;
                    }
                    else{
                        linearLayout.setVisibility(View.VISIBLE);
                        listwearId--;
                    }
                }
                if(list.get((int) arg2).equals("SiChuan")){
                    Log.d(LYTAG,"You Click SiChuan");
                }
                if(list.get((int) arg2).equals("US")){
                    Log.d(LYTAG,"You Click US");
                }
                if(list.get((int) arg2).equals("AnHui")){
                    Log.d(LYTAG,"You Click AnHui");
                }
                if(list.get((int) arg2).equals("XiZang")){
                    Log.d(LYTAG,"You Click AnHui");
                }
                if(list.get((int) arg2).equals("LiaoNing")){
                    Log.d(LYTAG,"You Click LiaoNing");
                }
            }
        });*/
package com.example.ts7.weartherapplication;


import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WeatherAdapter extends ArrayAdapter<Weather> {
    private int resourceId;

    private static final String TAG = "LY--WeatherAdapter";
    private static final String LYTAG = "LY--WeatherAdapter";

    private WeatherEntity weatherEntity = new WeatherEntity();
    private MainModel model = new MainModel();
    private List<Weather> arrayListWeather;
    private LayoutInflater inflater;
    Handler handler;
    public WeatherAdapter(Context context,int textViewResourceId,List<Weather> objects){
        super(context,textViewResourceId,objects);
        this.arrayListWeather = objects;
        inflater = LayoutInflater.from(context);
        resourceId = textViewResourceId;
    }

    public static final int SHOW_RESPONSE=0;//用于更新操作

    ///

    Handler getHanderAdapter(){
        return handler;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arrayListWeather.size();
    }

    @Override
    public Weather getItem(int position) {
        // TODO Auto-generated method stub
        Log.d(TAG, "getItem: "+position);
        return arrayListWeather.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    ///

    public void deleteItem(String cityname){
        Log.d(TAG, "deleteItem: ");
        //得到第一个可见item项的位置
        Weather weather = new Weather(cityname);
        for (int i = 0;i< arrayListWeather.size();i++){
            if (arrayListWeather.get(i).getWeatherCityName().equals(weather.getWeatherCityName())){
                arrayListWeather.remove(i);
                View view = LayoutInflater.from(getContext()).inflate(resourceId,null,false);
                Log.d(TAG, "deleteItem: Listview: ");
                this.notifyDataSetChanged();
            }
        }
        Log.d(TAG, "deleteItem: arraylist: "+arrayListWeather.size());
    }

    public void addItem(String cityname){
        Log.d(TAG, "addItem: "+cityname.toString());

        Weather weather = new Weather(cityname);
        for (int i = 0;i< arrayListWeather.size();i++){
            if (arrayListWeather.get(i).getWeatherCityName().equals(weather.getWeatherCityName())){
                Log.d(TAG, "addItem: 城市已经存在");
                return;
            }
        }
        arrayListWeather.add(weather);
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){ //回调函数
        Log.d(LYTAG, "getView: "+position);
        final Weather weather = getItem(position);  //获取当前项weather实例

        ViewHolder viewHolder = new ViewHolder();

        if(convertView == null){
            Log.d(LYTAG,"第一次创建convertView");
            convertView = LayoutInflater.from(getContext()).inflate(resourceId,
                    parent,false);

            //绑定控件
            viewHolder.cityName = (TextView) convertView.findViewById(R.id.item_cityname);
            viewHolder.weatherState = (TextView) convertView.findViewById(R.id.item_weatherstate);
            viewHolder.weatherTemperature = (TextView) convertView.findViewById(R.id.item_weathertemperature);
            viewHolder.weatherDate = (TextView) convertView.findViewById(R.id.item_weatherdata);

            viewHolder.tvsendibletemperature = (TextView) convertView.findViewById(R.id.tv_sendibletemperature);
            viewHolder.tvatmosphere = (TextView) convertView.findViewById(R.id.tv_atmosphere);
            viewHolder.tvcloudage = (TextView) convertView.findViewById(R.id.tv_cloudage);
            viewHolder.tvprecipitation = (TextView) convertView.findViewById(R.id.tv_precipitation);
            viewHolder.tvrelativehumidity = (TextView) convertView.findViewById(R.id.tv_relativehumidity);
            viewHolder.tvvisibility = (TextView) convertView.findViewById(R.id.tv_visibility);
            viewHolder.tvwinddirection = (TextView) convertView.findViewById(R.id.tv_winddirection);
            viewHolder.tvwindpower = (TextView) convertView.findViewById(R.id.tv_windpower);
            viewHolder.tvwindsnowdrift = (TextView) convertView.findViewById(R.id.tv_windsnowdrift);

            viewHolder.llWeather = (LinearLayout) convertView.findViewById(R.id.ll_weather);
            viewHolder.llDetail = (LinearLayout) convertView.findViewById(R.id.ll_detail);

            convertView.setTag(viewHolder); //将viewHolder存储在View中
        }else{
            Log.d(LYTAG,"复用convertView");
            viewHolder = (ViewHolder) convertView.getTag(); //重新获取ViewHolder
        }

        final ViewHolder finalViewHolder = viewHolder;
        handler=new Handler(){
            public void handleMessage(Message msg){
                Log.d(LYTAG, "handleMessage: 得到数据");
                //如果返现msg.what=SHOW_RESPONSE，则进行制定操作，如想进行其他操作，则在子线程里将SHOW_RESPONSE改变
                switch (msg.what){
                    case SHOW_RESPONSE:
                        WeatherEntity response=(WeatherEntity) msg.obj;
                        //进行UI操作，将结果显示到界面上
                        //responseText.setText(response);
                        Log.d(LYTAG,"更新数据");
                        weatherEntity = response;

                        finalViewHolder.tvwindsnowdrift.setText(weatherEntity.getHeWeather6().get(0).getNow().getWind_spd()+"");
                        finalViewHolder.tvwindpower.setText(weatherEntity.getHeWeather6().get(0).getNow().getWind_sc()+"");
                        finalViewHolder.tvwinddirection.setText(weatherEntity.getHeWeather6().get(0).getNow().getWind_dir());
                        finalViewHolder.tvvisibility.setText(weatherEntity.getHeWeather6().get(0).getNow().getVis());
                        finalViewHolder.tvrelativehumidity.setText(weatherEntity.getHeWeather6().get(0).getNow().getHum());
                        finalViewHolder.tvprecipitation.setText(weatherEntity.getHeWeather6().get(0).getNow().getPcpn());
                        finalViewHolder.tvcloudage.setText(weatherEntity.getHeWeather6().get(0).getNow().getCloud());
                        finalViewHolder.tvatmosphere.setText(weatherEntity.getHeWeather6().get(0).getNow().getPres());
                        finalViewHolder.weatherDate.setText(weatherEntity.getHeWeather6().get(0).getUpdate().getLoc());
                        finalViewHolder.weatherTemperature.setText(weatherEntity.getHeWeather6().get(0).getNow().getTmp());
                        finalViewHolder.weatherState.setText(weatherEntity.getHeWeather6().get(0).getNow().getCond_txt());
                        finalViewHolder.cityName.setText(weatherEntity.getHeWeather6().get(0).getBasic().getLocation());
                        finalViewHolder.tvsendibletemperature.setText(weatherEntity.getHeWeather6().get(0).getNow().getFl());
                }
            }
        };

        Log.d(LYTAG,"城市：　"+weather.getWeatherCityName());
        //从网络上获取指定的城市天气
        model.getData(weather.getWeatherCityName(),handler);

//控制显示和隐藏
        final ViewHolder viewHolder1 = viewHolder;
        viewHolder.llWeather.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(viewHolder1.llDetail.getVisibility() == View.GONE){
                    //Log.d(LYTAG,"one");
                    viewHolder1.llDetail.setVisibility(View.VISIBLE);
                }
                else{
                    viewHolder1.llDetail.setVisibility(View.GONE);
                }
            }
        });
        return convertView;
    }


    class ViewHolder{
        TextView cityName;              //城市名
        TextView weatherState;          //天气状态
        TextView weatherTemperature;    //天气温度
        TextView weatherDate;           //日期
        LinearLayout llWeather;         //
        LinearLayout llDetail;          //

        TextView tvsendibletemperature; //体感温度
        TextView tvwinddirection;       //风向
        TextView tvwindpower;           //风力
        TextView tvwindsnowdrift;       //风速
        TextView tvrelativehumidity;    //相对湿度
        TextView tvprecipitation;       //降水量
        TextView tvatmosphere;          //大气压强
        TextView tvvisibility;          //能见度
        TextView tvcloudage;            //云量
    }
}

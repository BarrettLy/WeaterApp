package com.example.ts7.weartherapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class MainActivity extends AppCompatActivity implements ImainView{

    private static final String LYTAG = "LY--MainActivity";
    public String TAG = "LY--MainActivity";
    private PopupMenu popupMenu;
    private Menu menu;
    private Button buttonSelectCity;
    private Button buttonDeleteCity;
    private Button buttonSaveCity;
    private List<Weather> weatherList = new ArrayList<>();
    private ArrayList<String> citylist = new ArrayList<>();
    private MainPresenter mainPresenter;
    private ArrayList<String> weathersshow = new ArrayList<>();
    private WeatherAdapter adapter;
    private ListView listView;
    //选择展示城市菜单
    private void showSelectPopupMenu(View view) {
        // 这里的view代表popupMenu需要依附的view
         popupMenu= new PopupMenu(MainActivity.this, view);

        // 获取布局文件
        popupMenu.getMenuInflater().inflate(R.menu.menumain, popupMenu.getMenu());
        final Iterator<String> iterator = citylist.iterator();
        while (iterator.hasNext()){
            popupMenu.getMenu().add(iterator.next());
        }
        popupMenu.show();
        // 通过上面这几行代码，就可以把控件显示出来了
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // 控件每一个item的点击事件
                Iterator<String> iterator = citylist.iterator();
                while (iterator.hasNext()){
                    if (item.getTitle().equals(iterator.next())){
                        weathersshow.add(item.getTitle().toString());
                        adapter.addItem(item.getTitle().toString());
                    }
                }
                return true;
            }
        });

        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                // 控件消失时的事件
            }
        });
    }

    //删除城市菜单
    private void showdeletePopupMenu(final View view) {
        // 这里的view代表popupMenu需要依附的view
       popupMenu = new PopupMenu(MainActivity.this, view);
        // 获取布局文件
        popupMenu.getMenuInflater().inflate(R.menu.menumain, popupMenu.getMenu());
        final Iterator<String> iterator = citylist.iterator();
        while (iterator.hasNext()){
            popupMenu.getMenu().add(iterator.next());
        }
        popupMenu.show();
        // 通过上面这几行代码，就可以把控件显示出来了
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // 控件每一个item的点击事件
                Iterator<String> iterator = citylist.iterator();
                while (iterator.hasNext()){
                    if (item.getTitle().equals(iterator.next())){
                        weathersshow.remove(item.getTitle().toString());
                        //Log.d(TAG, "onMenuItemClick: wethersshow"+weathersshow.toString());
                        adapter.deleteItem(item.getTitle().toString());
                    }
                }
                return true;
            }
        });

        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                // 控件消失时的事件
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_weather);

        Log.d(LYTAG," MainActivity onCreate");

        initWeather();
        initview();
        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            mainPresenter.getSaveCity(adapter,weathersshow);
        } else {
            //提示用户开户权限   拍照和读写sd卡权限
            String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(MainActivity.this, perms, RESULT_CANCELED);
        }
    }

    void initview(){
        buttonSelectCity = (Button)findViewById(R.id.btn_select_city);
        buttonSelectCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectPopupMenu(v);
            }
        });
        buttonSelectCity.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        buttonDeleteCity = (Button)findViewById(R.id.btn_delete_city);
        buttonDeleteCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdeletePopupMenu(v);
            }
        });
        buttonSaveCity = (Button)findViewById(R.id.btn_save_city);
        buttonSaveCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    mainPresenter.saveCity(weathersshow);
                    Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                } else {
                    //提示用户开户权限   拍照和读写sd卡权限
                    String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                    ActivityCompat.requestPermissions(MainActivity.this, perms, RESULT_CANCELED);
                }

            }
        });
        listView = (ListView) findViewById(R.id.list_weather_item);
        adapter = new WeatherAdapter(MainActivity.this,R.layout.item_weather,weatherList);
        listView.setAdapter(adapter);
    }


    //初始化weather数据
    private void initWeather(){
        mainPresenter = new MainPresenter(this);
        mainPresenter.setCityList(citylist);

        /*  for(int i=0;i<1;i++){
            Weather one = new Weather("武汉","Cloudy","16 C","2018/11/15");
            weatherList.add(one);
            citylist.add(one.getWeatherCityName());
        }*/

    }

    @Override
    public void setCityListResule(ArrayList<String> arrayList) {
        citylist = arrayList;
        //Log.d(LYTAG, "setCityList: "+arrayList.toString());
    }
}

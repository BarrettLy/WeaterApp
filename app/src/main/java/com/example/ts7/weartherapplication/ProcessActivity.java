package com.example.ts7.weartherapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProcessActivity extends AppCompatActivity {
    private CircleProgress mCpLoading;
    private Button mBtnLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process);
        mCpLoading = (CircleProgress)findViewById(R.id.cp_loading);
        mBtnLoading = (Button)findViewById(R.id.progress_circular);
        mBtnLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCpLoading.setProgress(100,5000);
            }
        });

        //我在自定义View写了一个接口回调,来监听进度
        mCpLoading.setOnCircleProgressListener(new CircleProgress.OnCircleProgressListener() {
            @Override
            public boolean OnCircleProgress(int progress) {
                if(progress==100){
                    mCpLoading.setProgress(0);
                }
                return false;
            }
        });
    }

}

package com.lwm.guoluapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;

public class MainActivity extends Activity {

    {
        System.loadLibrary("guolu");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final PressureView pressureView = new PressureView(this);
        setContentView(pressureView);
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    //休眠1秒钟
                    SystemClock.sleep(500);
                    //getPressure()有可能是一个负值，所以取一个绝对值（Math.abs()）
                    int pressure = Math.abs(getPressure());//传过来的值为 0~250
                    pressureView.setPressure(pressure);

                    if (pressure > 220) {//如果压力大于220就要爆炸
                        break;
                    }
                }
            }
        }.start();
    }

    // native代码
    // 作用：调用 C 代码中的对应的方法
    public native int getPressure();
}

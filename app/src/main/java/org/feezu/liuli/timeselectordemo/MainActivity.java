package org.feezu.liuli.timeselectordemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import org.feezu.liuli.timeselector.TimeSelector;
import org.feezu.liuli.timeselector.Utils.DateUtil;

import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private TimeSelector timeSelector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        timeSelector = new TimeSelector(this, new TimeSelector.ResultHandler() {
            @Override
            public void handle(Date time) {
                Toast.makeText(getApplicationContext(), DateUtil.format(time, TimeSelector.FORMAT_STR), Toast.LENGTH_LONG).show();
            }
        }, "2016-01-30 00:00", "2018-12-31 00:00");
        timeSelector.setIsLoop(false);
        timeSelector.setMode(TimeSelector.MODE.YMD);
        timeSelector.setCancelable(true);
        timeSelector.setDefaultDate("2018-2-27 20:30");
        timeSelector.setPrimaryColor(0xFF458909);
//        timeSelector.setIsLoop(false);
    }

    public void show(View v) {
        timeSelector.show();
    }
}

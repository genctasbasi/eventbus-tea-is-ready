package com.escmobile.teaisreadyeventbus;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import com.escmobile.teaisreadyeventbus.events.CoffeeIsReadyEvent;
import com.escmobile.teaisreadyeventbus.events.NothingIsReadyEvent;
import com.escmobile.teaisreadyeventbus.events.TeaIsReadyEvent;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    private void teaIsReady() {
        EventBus.getDefault().post(new TeaIsReadyEvent());
    }

    private void coffeeIsReady() {
        EventBus.getDefault().post(new CoffeeIsReadyEvent());
    }

    private void nothingIsReady() {
        EventBus.getDefault().post(new NothingIsReadyEvent());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setButtons();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setButtons() {

        findViewById(R.id.button_tea_is_ready).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teaIsReady();
            }
        });

        findViewById(R.id.button_coffee_is_ready).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffeeIsReady();
            }
        });

        findViewById(R.id.button_nothing_is_ready).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nothingIsReady();
            }
        });

    }
}

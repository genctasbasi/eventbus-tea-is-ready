package com.escmobile.teaisreadyeventbus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.escmobile.teaisreadyeventbus.events.NothingIsReadyEvent;
import com.escmobile.teaisreadyeventbus.events.TeaIsReadyEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * A placeholder fragment containing a simple view.
 */
public class Fragment_1 extends Fragment {

    TextView viewDesc;

    public Fragment_1() {
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_1, container, false);

        viewDesc = (TextView) root.findViewById(R.id.textview_desc);

        return root;
    }

    @Subscribe
    public void handleNothingIsReady(NothingIsReadyEvent event) {
        viewDesc.setText("Fragment 1 - Waiting for tea!");
    }

    @Subscribe
    public void handleTeaEvent(TeaIsReadyEvent event) {
        viewDesc.setText("Ah I like tea!");
    }
}

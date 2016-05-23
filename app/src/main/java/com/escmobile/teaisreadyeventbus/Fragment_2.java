package com.escmobile.teaisreadyeventbus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.escmobile.teaisreadyeventbus.events.CoffeeIsReadyEvent;
import com.escmobile.teaisreadyeventbus.events.NothingIsReadyEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * A placeholder fragment containing a simple view.
 */
public class Fragment_2 extends Fragment {

    TextView viewDesc;

    public Fragment_2() {
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
        View root = inflater.inflate(R.layout.fragment_2, container, false);

        viewDesc = (TextView) root.findViewById(R.id.textview_desc);

        return root;
    }

    @Subscribe
    public void handleNothingIsReady(NothingIsReadyEvent event) {
        viewDesc.setText("Fragment 2 - Waiting for coffee!");
    }

    @Subscribe
    public void handleTeaEvent(CoffeeIsReadyEvent event) {
        viewDesc.setText("Ah I like coffee!");
    }
}

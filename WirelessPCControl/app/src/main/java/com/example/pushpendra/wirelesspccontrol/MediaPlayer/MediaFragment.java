package com.example.pushpendra.wirelesspccontrol.MediaPlayer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.pushpendra.wirelesspccontrol.MainActivity;
import com.example.pushpendra.wirelesspccontrol.R;

public class MediaFragment extends Fragment implements View.OnClickListener{
    private ImageButton stop, full, vol_inc, vol_dec, prev, next, play, mute, rewind, forward;

    public MediaFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_media, container, false);

        stop = (ImageButton) rootView.findViewById(R.id.media_stop);
        full = (ImageButton) rootView.findViewById(R.id.media_full_screen);
        vol_inc = (ImageButton) rootView.findViewById(R.id.media_vol_inc);
        vol_dec = (ImageButton) rootView.findViewById(R.id.media_vol_dec);
        prev = (ImageButton) rootView.findViewById(R.id.media_prev);
        next = (ImageButton) rootView.findViewById(R.id.media_next);
        play = (ImageButton) rootView.findViewById(R.id.media_play);
        mute = (ImageButton) rootView.findViewById(R.id.media_mute);
        rewind = (ImageButton) rootView.findViewById(R.id.media_rewind);
        forward = (ImageButton) rootView.findViewById(R.id.media_forward);

        stop.setOnClickListener(this);
        full.setOnClickListener(this);
        vol_inc.setOnClickListener(this);
        vol_dec.setOnClickListener(this);
        prev.setOnClickListener(this);
        next.setOnClickListener(this);
        play.setOnClickListener(this);
        mute.setOnClickListener(this);
        rewind.setOnClickListener(this);
        forward.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String action = "";
        int keyCode = 0;
        switch (id) {
            case R.id.media_stop:
                action = "TYPE_KEY";
                keyCode = 83;
                break;
            case R.id.media_full_screen:
                action = "TYPE_KEY";
                keyCode = 70;
                break;
            case R.id.media_vol_inc:
                action = "UP_ARROW_KEY";
                break;
            case R.id.media_vol_dec:
                action = "DOWN_ARROW_KEY";
                break;
            case R.id.media_rewind:
                action = "LEFT_ARROW_KEY";
                break;
            case R.id.media_forward:
                action = "RIGHT_ARROW_KEY";
                break;
            case R.id.media_next:
                action = "TYPE_KEY";
                keyCode = 78;
                break;
            case R.id.media_prev:
                action = "TYPE_KEY";
                keyCode = 80;
                break;
            case R.id.media_mute:
                action = "TYPE_KEY";
                keyCode = 77;
                break;
            case R.id.media_play:
                action = "TYPE_KEY";
                keyCode = 32;
                break;
        }
        sendActionToServer(action, keyCode);
    }

    private void sendActionToServer(String action, int keyCode) {
        MainActivity.sendMessageToServer(action);
        if(keyCode !=0 )
            MainActivity.sendMessageToServer(keyCode);
    }
}

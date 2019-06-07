package com.example.pushpendra.wirelesspccontrol.gamepad;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.pushpendra.wirelesspccontrol.MainActivity;
import com.example.pushpendra.wirelesspccontrol.R;

public class GamepadFragment extends Fragment implements View.OnClickListener{
    private ImageButton btn_left, btn_right, btn_up, btn_down, btn_w, btn_a;
    private Button btn_l1, btn_l2, btn_r1, btn_r2, btn_s, btn_d;

    public GamepadFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gamepad, container, false);
        btn_left = (ImageButton) rootView.findViewById(R.id.gm_left);
        btn_right = (ImageButton) rootView.findViewById(R.id.gm_right);
        btn_up = (ImageButton) rootView.findViewById(R.id.gm_up);
        btn_down = (ImageButton) rootView.findViewById(R.id.gm_down);
        btn_w = (ImageButton) rootView.findViewById(R.id.gm_w);
        btn_a =(ImageButton) rootView.findViewById(R.id.gm_a);

        btn_l1 = (Button) rootView.findViewById(R.id.gm_l1);
        btn_l2 = (Button) rootView.findViewById(R.id.gm_l2);
        btn_r1 = (Button) rootView.findViewById(R.id.gm_r1);
        btn_r2 = (Button) rootView.findViewById(R.id.gm_r2);
        btn_s = (Button) rootView.findViewById(R.id.gm_s);
        btn_d = (Button) rootView.findViewById(R.id.gm_d);


        btn_left.setOnClickListener(this);
        btn_right.setOnClickListener(this);
        btn_up.setOnClickListener(this);
        btn_down.setOnClickListener(this);

        btn_w.setOnClickListener(this);
        btn_a.setOnClickListener(this);
        btn_s.setOnClickListener(this);
        btn_d.setOnClickListener(this);

        btn_l1.setOnClickListener(this);
        btn_l2.setOnClickListener(this);

        btn_r1.setOnClickListener(this);
        btn_r2.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String action = "NULL";
        int keyCode = 0;

        switch(id){
            case R.id.gm_up :
                action = "UP_ARROW_KEY";
                break;
            case R.id.gm_left :
                action = "LEFT_ARROW_KEY";
                break;
            case R.id.gm_right :
                action = "RIGHT_ARROW_KEY";
                break;
            case R.id.gm_down :
                action = "DOWN_ARROW_KEY";
                break;
            case R.id.gm_w :
                action = "TYPE_KEY";
                break;
            case R.id.gm_a :
                action = "TYPE_KEY";
                break;
            case R.id.gm_s :
                action = "TYPE_KEY";
                break;
            case R.id.gm_d :
                action = "TYPE_KEY";
                break;
        }
        sendActionToServer(action, keyCode);
    }

    private void sendActionToServer(String action, int keyCode) {
        MainActivity.sendMessageToServer(action);
        if(keyCode != 0)
            MainActivity.sendMessageToServer(keyCode);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getResources().getString(R.string.gamepad));
    }
}

package com.example.pushpendra.wirelesspccontrol.presentation;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pushpendra.wirelesspccontrol.MainActivity;
import com.example.pushpendra.wirelesspccontrol.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PresentationFragment extends Fragment implements View.OnClickListener  {

    private Button downArrowButton, upArrowButton, fullscreenbtn, leftArrowButton, rightArrowButton, exit_btn;

    public PresentationFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_presentation, container, false);
        downArrowButton = (Button) rootView.findViewById(R.id.downArrowButton);
        upArrowButton = (Button) rootView.findViewById(R.id.upArrowButton);
        leftArrowButton = (Button) rootView.findViewById(R.id.leftArrowButton);
        rightArrowButton = (Button) rootView.findViewById(R.id.rightArrowButton);
        fullscreenbtn = (Button) rootView.findViewById(R.id.full_screen_btn);
        exit_btn = (Button) rootView.findViewById(R.id.exit_btn);
        downArrowButton.setOnClickListener(this);
        leftArrowButton.setOnClickListener(this);
        upArrowButton.setOnClickListener(this);
        rightArrowButton.setOnClickListener(this);
        fullscreenbtn.setOnClickListener(this);
        exit_btn.setOnClickListener(this);

        return  rootView;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String action = "F5_KEY";
        int keyCode = 0;
        switch (id) {
            case R.id.downArrowButton:
                action = "DOWN_ARROW_KEY";
                break;
            case R.id.leftArrowButton:
                action = "LEFT_ARROW_KEY";
                break;
            case R.id.upArrowButton:
                action = "UP_ARROW_KEY";
                break;
            case R.id.rightArrowButton:
                action = "RIGHT_ARROW_KEY";
                break;
            case R.id.full_screen_btn:
                action = "F5_KEY";
                break;
            case R.id.exit_btn:
                action = "TYPE_KEY";
                keyCode = 27;
                break;
        }
        sendActionToServer(action, keyCode);
    }

    private void sendActionToServer(String action, int keyCode) {
        MainActivity.sendMessageToServer(action);
        if(keyCode != 0)
            MainActivity.sendMessageToServer(keyCode);
    }
}

package com.example.pushpendra.wirelesspccontrol.keyboard;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pushpendra.wirelesspccontrol.MainActivity;
import com.example.pushpendra.wirelesspccontrol.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KeyboardFragment extends Fragment implements View.OnTouchListener, View.OnClickListener, TextWatcher {

    private EditText typeHereEditText;
    private Button ctrlButton, altButton, tabButton, escButton, homeButton, pgUPButton, pgDNButton, endButton, keyUPButton;
    private Button delButton, keyLeftButton, keyRightButton, keyDownButton, f1Button, f2Button, f3Button, f4Button, f5Button;
    private Button f6Button, f7Button, f8Button, f9Button, f10Button, f11Button, f12Button, clearTextButton;
    private String previousText = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_keyboard, container, false);
        initialization(rootView);
        return rootView;
    }

    public KeyboardFragment(){

    }

    private void initialization(View rootView) {
        typeHereEditText = (EditText) rootView.findViewById(R.id.key_text);
        clearTextButton = (Button) rootView.findViewById(R.id.key_clear_text);
        ctrlButton = (Button) rootView.findViewById(R.id.key_ctrl);
        altButton = (Button) rootView.findViewById(R.id.key_alt);
        tabButton = (Button) rootView.findViewById(R.id.key_tab);
        escButton = (Button) rootView.findViewById(R.id.key_esc);
        homeButton = (Button) rootView.findViewById(R.id.key_home);
        pgUPButton = (Button) rootView.findViewById(R.id.key_PgUp);
        pgDNButton = (Button) rootView.findViewById(R.id.key_PgDn);
        endButton = (Button) rootView.findViewById(R.id.key_end);
        keyUPButton = (Button) rootView.findViewById(R.id.key_up);
        delButton = (Button) rootView.findViewById(R.id.key_del);
        keyLeftButton = (Button) rootView.findViewById(R.id.key_left);
        keyRightButton = (Button) rootView.findViewById(R.id.key_right);
        keyDownButton = (Button) rootView.findViewById(R.id.key_down);
        f1Button = (Button) rootView.findViewById(R.id.key_f1);
        f2Button = (Button) rootView.findViewById(R.id.key_f2);
        f3Button = (Button) rootView.findViewById(R.id.key_f3);
        f4Button = (Button) rootView.findViewById(R.id.key_f4);
        f5Button = (Button) rootView.findViewById(R.id.key_f5);
        f6Button = (Button) rootView.findViewById(R.id.key_f6);
        f7Button = (Button) rootView.findViewById(R.id.key_f7);
        f8Button = (Button) rootView.findViewById(R.id.key_f8);
        f9Button = (Button) rootView.findViewById(R.id.key_f9);
        f10Button = (Button) rootView.findViewById(R.id.key_f10);
        f11Button = (Button) rootView.findViewById(R.id.key_f11);
        f12Button = (Button) rootView.findViewById(R.id.key_f12);

        ctrlButton.setOnTouchListener(this);
        altButton.setOnTouchListener(this);
        escButton.setOnClickListener(this);
        delButton.setOnClickListener(this);
        tabButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
        pgUPButton.setOnClickListener(this);
        pgDNButton.setOnClickListener(this);
        endButton.setOnClickListener(this);
        keyUPButton.setOnClickListener(this);
        keyLeftButton.setOnClickListener(this);
        keyRightButton.setOnClickListener(this);
        keyDownButton.setOnClickListener(this);
        f1Button.setOnClickListener(this);
        f2Button.setOnClickListener(this);
        f3Button.setOnClickListener(this);
        f4Button.setOnClickListener(this);
        f5Button.setOnClickListener(this);
        f6Button.setOnClickListener(this);
        f7Button.setOnClickListener(this);
        f8Button.setOnClickListener(this);
        f9Button.setOnClickListener(this);
        f10Button.setOnClickListener(this);
        f11Button.setOnClickListener(this);
        f12Button.setOnClickListener(this);
        typeHereEditText.addTextChangedListener(this);
        clearTextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.key_clear_text) {
            typeHereEditText.setText("");
        }else {
            int keyCode = 17;//dummy initialization
            String action = "TYPE_KEY";
            switch (id) {
                case R.id.key_del:
                    keyCode = 8;
                    break;
                case R.id.key_tab:
                    keyCode = 9;
                    break;
                case R.id.key_esc:
                    keyCode = 27;
                    break;
                case R.id.key_home:
                    keyCode = 36;
                    break;
                case R.id.key_PgUp:
                    keyCode = 33;
                    break;
                case R.id.key_PgDn:
                    keyCode = 34;
                    break;
                case R.id.key_end:
                    keyCode = 35;
                    break;
                case R.id.key_up:
                    keyCode =38;
                    break;
                case R.id.key_left:
                    keyCode = 37;
                    break;
                case R.id.key_right:
                    keyCode = 39;
                    break;
                case R.id.key_down:
                    keyCode = 40;
                    break;
                case R.id.key_f1:
                    keyCode = 112;
                    break;
                case R.id.key_f2:
                    keyCode = 113;
                    break;
                case R.id.key_f3:
                    keyCode = 114;
                    break;
                case R.id.key_f4:
                    keyCode = 115;
                    break;
                case R.id.key_f5:
                    keyCode = 116;
                    break;
                case R.id.key_f6:
                    keyCode = 117;
                    break;
                case R.id.key_f7:
                    keyCode = 118;
                    break;
                case R.id.key_f8:
                    keyCode = 119;
                    break;
                case R.id.key_f9:
                    keyCode = 120;
                    break;
                case R.id.key_f10:
                    keyCode = 121;
                    break;
                case R.id.key_f11:
                    keyCode = 122;
                    break;
                case R.id.key_f12:
                    keyCode = 123;
                    break;
            }
            sendKeyCodeToServer(action, keyCode);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        char ch = newCharacter(charSequence, previousText);
        if (ch == 0) {
            return;
        }
        MainActivity.sendMessageToServer("TYPE_CHARACTER");
        MainActivity.sendMessageToServer(Character.toString(ch));
        previousText = charSequence.toString();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        String action = "KEY_PRESS";
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            action = "KEY_PRESS";
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            action = "KEY_RELEASE";
        }
        int keyCode = 17;//dummy initialization
        switch (view.getId()) {
            case R.id.key_ctrl:
                keyCode = 17;
                break;
            case R.id.key_alt:
                keyCode = 18;
                break;
        }
        sendKeyCodeToServer(action, keyCode);
        return false;
    }

    private char newCharacter(CharSequence currentText, CharSequence previousText) {
        char ch = 0;
        int currentTextLength = currentText.length();
        int previousTextLength = previousText.length();
        int difference = currentTextLength - previousTextLength;
        if (currentTextLength > previousTextLength) {
            if (1 == difference) {
                ch = currentText.charAt(previousTextLength);
            }
        } else if (currentTextLength < previousTextLength) {
            if (-1 == difference) {
                ch = '\b';
            } else {
                ch = ' ';
            }
        }
        return ch;
    }

    private void sendKeyCodeToServer(String action, int keyCode) {
        MainActivity.sendMessageToServer(action);
        MainActivity.sendMessageToServer(keyCode);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getResources().getString(R.string.keyboard));
    }
}


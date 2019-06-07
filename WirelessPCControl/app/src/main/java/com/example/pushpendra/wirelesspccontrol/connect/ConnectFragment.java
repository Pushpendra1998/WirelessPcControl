package com.example.pushpendra.wirelesspccontrol.connect;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Socket;

import com.example.pushpendra.wirelesspccontrol.MainActivity;
import com.example.pushpendra.wirelesspccontrol.R;
import com.example.pushpendra.wirelesspccontrol.server.Server;


public class ConnectFragment extends Fragment {

    Button connectButton,scanqrcode;
    EditText ipAddressEditText, portNumberEditText;
    Fragment fragment;
    TextView status;
    SharedPreferences sharedPreferences;
    String ip_add,port;
    static boolean isConnect = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_connect, container, false);
        status = (TextView) rootView.findViewById(R.id.status);
        ipAddressEditText = (EditText) rootView.findViewById(R.id.ip_address);
        portNumberEditText = (EditText) rootView.findViewById(R.id.port_no);
        connectButton = (Button) rootView.findViewById(R.id.connect);
        scanqrcode = (Button) rootView.findViewById(R.id.qr_code);
        status.setText("Disconnected");
        getData();
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeConnection();
            }
        });
        scanqrcode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fragment = new qr_code_scanner();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame,fragment);
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }
    void getData()
    {
        try {
            sharedPreferences = getActivity().getSharedPreferences("ip&port", Context.MODE_PRIVATE);
            String str = sharedPreferences.getString("ip&port", "");
            // Toast.makeText(getActivity(), ""+str, Toast.LENGTH_SHORT).show();
            int index = str.indexOf('&');
            ip_add = str.substring(0, index);
            port = str.substring(index+1,str.length());
            // Toast.makeText(getActivity(), "" +port, Toast.LENGTH_SHORT).show();
            ipAddressEditText.setText(ip_add);
            portNumberEditText.setText(port);
            //makeConnection();
        }
        catch (Exception e)
        {

        }
    }

    void makeConnection()
    {
        status.setText("Connecting ....");
        connectButton.setEnabled(false);
        ip_add = String.valueOf(ipAddressEditText.getText());
        port = String.valueOf(portNumberEditText.getText());
        new MakeConnection(ip_add, port, getActivity()) {
            @Override
            public void receiveData(Object result) {
                MainActivity.clientSocket = (Socket) result;
                if (MainActivity.clientSocket == null) {
                    Toast.makeText(getActivity(), "Server is not listening", Toast.LENGTH_SHORT).show();
                    connectButton.setEnabled(true);
                } else {
                    status.setText("connected");
                }
            }
        }.execute();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getResources().getString(R.string.connect));
    }
}

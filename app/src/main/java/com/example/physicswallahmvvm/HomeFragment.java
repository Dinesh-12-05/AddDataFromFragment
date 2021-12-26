package com.example.physicswallahmvvm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    private Button btnAdd, btnDelete;
    private EditText etNameList;
    SendDataInterface sendDataInterface;

    public HomeFragment() {
        // Required empty public constructor
    }
    public interface SendDataInterface{
        public void sendData(String data);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
       // TextView tvName = view.findViewById(R.id.tvname);
        //tvName.setText(this.getArguments().getString("message "));
        btnAdd = view.findViewById(R.id.btnadd);
        btnDelete = view.findViewById(R.id.btndel);
        etNameList = view.findViewById(R.id.etnamelist);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  data = etNameList.getText().toString();
                sendDataInterface.sendData(data);

            }
        });
        return view;


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;

        try {
            sendDataInterface = (SendDataInterface) activity;

        }catch (RuntimeException a){
            throw new RuntimeException(activity.toString()+"Must implement Method");
        }

    }
}
package com.example.physicswallahmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HomeFragment.SendDataInterface, QuantityListener {

    Button btnAddList, btnDelete;
    EditText etName;
    TextView tvMyTextView;
    RecyclerView recyclerView;
    QuantityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMyTextView = findViewById(R.id.mytextview);
        recyclerView = findViewById(R.id.recycler_view);

        setRecyclerView();


        if (findViewById(R.id.framelayoutTwo)!=null){
            if (savedInstanceState != null){
                return;
            }
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.framelayoutTwo, new HomeFragment(), null).commit();
        }
    }

    private ArrayList<String> getQuantityData(){
        ArrayList<String > arrayList = new ArrayList<>();
        arrayList.add("Cat");
        arrayList.add("Cat");
        arrayList.add("Cat");
        arrayList.add("Cat");
        arrayList.add("Cat");
        arrayList.add("Cat");
        arrayList.add("Cat");
        arrayList.add("Bat");
        return arrayList;
    }


    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new QuantityAdapter(this, getQuantityData(), this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void sendData(String data) {
        tvMyTextView.setText(data);

    }

    @Override
    public void onQunatityChange(ArrayList<String> arrayList) {
        Toast.makeText(this, arrayList.toString(), Toast.LENGTH_SHORT).show();

    }
}
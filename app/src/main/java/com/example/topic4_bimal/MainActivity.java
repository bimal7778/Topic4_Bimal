package com.example.topic4_bimal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static String countries[] = { "Nepal","Kathmandu","India","Delhi","China","Beijing","Japan","Tokyo"};
    Button btnSave;

    private Map<String,String> dictionary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lstCountries=findViewById(R.id.cities);
        btnSave=findViewById(R.id.btnSave);
        dictionary=new HashMap<>();
        for(int i=0;i<countries.length;i+=2){
            dictionary.put(countries[i],countries[i+1]);
        }
        ArrayAdapter countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String> (dictionary.keySet()));
        lstCountries.setAdapter(countryAdapter);
        lstCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Country=parent.getItemAtPosition(position).toString();
                String capital=dictionary.get(Country);
                Intent intent=new Intent(MainActivity.this,activityTwo.class);
                intent.putExtra("myMessage",capital);
                startActivity(intent);
            }
        });

    }
}

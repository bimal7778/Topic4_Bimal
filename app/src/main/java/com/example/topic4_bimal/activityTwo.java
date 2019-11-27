package com.example.topic4_bimal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class activityTwo extends AppCompatActivity {
    TextView getMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        getMsg = findViewById(R.id.getMsg);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String message = bundle.getString("myMessage");
            getMsg.setText(message);
        } else {
            Toast.makeText(this, "No message found", Toast.LENGTH_SHORT).show();
        }

    }
}
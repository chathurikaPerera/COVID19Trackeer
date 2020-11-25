package com.example.covid19tracler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private TextView totalCases, newCases, recoveredCases, globalDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        totalCases =findViewById(R.id.globaltotalCases);
        newCases = findViewById(R.id.globalnewCases);
        recoveredCases = findViewById(R.id.globalrecoverCases);
        globalDeaths = findViewById(R.id.globaldeathCases);

        ArrayList<String> data = getIntent().getExtras().getStringArrayList("booolist");
        newCases.setText(data.get(0));
        totalCases.setText(data.get(1));
        globalDeaths.setText(data.get(2));
        recoveredCases.setText(data.get(3));
    }
}
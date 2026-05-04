package com.example.caloriecounterapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import com.example.caloriecounterapp.R;

import java.util.ArrayList;

import food_adapter.java.Food;
import food_adapter.java.FoodAdapter;

public class MainActivity extends AppCompatActivity {

    EditText etFood, etCal;
    TextView tvTotal;
    RecyclerView recyclerView;
    FoodAdapter adapter;

    ArrayList<Food> list = new ArrayList<>();
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFood = findViewById(R.id.etFood);
        etCal = findViewById(R.id.etCal);
        tvTotal = findViewById(R.id.tvTotal);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FoodAdapter(list);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.btnAdd).setOnClickListener(v -> {

            String name = etFood.getText().toString();
            String calStr = etCal.getText().toString();

            if (!name.isEmpty() && !calStr.isEmpty()) {

                int cal = Integer.parseInt(calStr);

                list.add(new Food(name, cal));
                adapter.notifyDataSetChanged();

                total += cal;
                tvTotal.setText("Total Calories: " + total);

                etFood.setText("");
                etCal.setText("");
            }
        });
    }
}
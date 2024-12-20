package com.example.laba_3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CallActivity extends AppCompatActivity {

    @Override
    protected void onStop() {
        Log.d("First Activity", "onStop called");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.d("First Activity", "onPause called");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("First Activity", "onResume called");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.d("First Activity", "onStart called");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        Log.d("First Activity", "onDestroy called");
        super.onDestroy();
    }

    private Button buttonCallTaxi;
    private TextView textViewRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("First Activity", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        Intent intent_sign = getIntent();
        Intent intent_address = new Intent("com.example.laba_3.AddressActivity");

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewPhone = findViewById(R.id.textViewPhone);
        textViewRoute = findViewById(R.id.textViewRoute);

        String fio = intent_sign.getStringExtra("Name") + " " + intent_sign.getStringExtra("Lastname");
        textViewName.setText(fio);
        textViewPhone.setText(intent_sign.getStringExtra("Phone"));

        Button buttonSetPath = findViewById(R.id.buttonSetPath);
        buttonCallTaxi = findViewById(R.id.buttonCallTaxi);

        buttonSetPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent_address, 3);
            }
        });

        buttonCallTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String route = textViewRoute.getText().toString();
                if (!route.isEmpty()) {
                    Toast.makeText(CallActivity.this, "Такси отправлено", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(CallActivity.this, "Укажите маршрут!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 3 && resultCode == RESULT_OK && data != null) {
            String city_a = data.getStringExtra("city_a");
            String street_a = data.getStringExtra("street_a");
            String house_a = data.getStringExtra("house_a");
            String city_b = data.getStringExtra("city_b");
            String street_b = data.getStringExtra("street_b");
            String house_b = data.getStringExtra("house_b");

            String route = "Откуда:\nг. " + city_a + ", ул. " + street_a + ", дом " + house_a + "\n\nКуда:\nг. " + city_b + ", ул. " + street_b + ", дом " + house_b;
            textViewRoute.setText(route);

            buttonCallTaxi.setEnabled(true);
            buttonCallTaxi.setAlpha(1.0f);
        }
    }
}
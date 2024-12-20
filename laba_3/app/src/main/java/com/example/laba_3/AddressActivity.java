package com.example.laba_3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddressActivity extends AppCompatActivity {

    @Override
    protected void onStop() {
        Log.d("Address Activity", "onStop called");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.d("Address Activity", "onPause called");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("Address Activity", "onResume called");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.d("Address Activity", "onStart called");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        Log.d("Address Activity", "onDestroy called");
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Address Activity", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        EditText editTextCity_A = findViewById(R.id.editTextCityA);
        EditText editTextStreet_A = findViewById(R.id.editTextStreetA);
        EditText editTextHouse_A = findViewById(R.id.editTextHouseA);
        EditText editTextCity_B = findViewById(R.id.editTextCityB);
        EditText editTextStreet_B = findViewById(R.id.editTextStreetB);
        EditText editTextHouse_B = findViewById(R.id.editTextHouseB);

        Intent intent = new Intent();

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city_a = editTextCity_A.getText().toString();
                String street_a = editTextStreet_A.getText().toString();
                String house_a = editTextHouse_A.getText().toString();
                String city_b = editTextCity_B.getText().toString();
                String street_b = editTextStreet_B.getText().toString();
                String house_b = editTextHouse_B.getText().toString();

                if (!city_a.isEmpty() && !street_a.isEmpty() && !house_a.isEmpty() && !city_b.isEmpty() && !street_b.isEmpty() && !house_b.isEmpty()) {
                    intent.putExtra("city_a", city_a);
                    intent.putExtra("street_a", street_a);
                    intent.putExtra("house_a", house_a);
                    intent.putExtra("city_b", city_b);
                    intent.putExtra("street_b", street_b);
                    intent.putExtra("house_b", house_b);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
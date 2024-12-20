package com.example.laba_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignActivity extends AppCompatActivity {

    @Override
    protected void onStop() {
        Log.d("Main Activity", "onStop called");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.d("Main Activity", "onPause called");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("Main Activity", "onResume called");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.d("Main Activity", "onStart called");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        Log.d("Main Activity", "onDestroy called");
        super.onDestroy();
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString("Name", editTextName.getText().toString());
        editor.putString("Lastname", editTextLastname.getText().toString());
        editor.putString("Phone", editTextPhone.getText().toString());
        editor.apply();
    }

    private EditText editTextName, editTextLastname, editTextPhone;
    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Main Activity", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        editTextName = findViewById(R.id.editTextName);
        editTextLastname = findViewById(R.id.editTextLastname);
        editTextPhone = findViewById(R.id.editTextPhone);

        Button button_registration = findViewById(R.id.buttonRegistration);

        sPref = getPreferences(MODE_PRIVATE);
        String name = sPref.getString("Name", "");
        String lastname = sPref.getString("Lastname", "");
        String phone = sPref.getString("Phone", "");

        if (!name.isEmpty() && !lastname.isEmpty() && !phone.isEmpty()) {
            editTextName.setText(name);
            editTextLastname.setText(lastname);
            editTextPhone.setText(phone);
            String log_in = "Log in";
            button_registration.setText(log_in);
        }

        Intent intent = new Intent(this, CallActivity.class);

        button_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String lastname = editTextLastname.getText().toString();
                String phone = editTextPhone.getText().toString();

                if (!name.isEmpty() && !lastname.isEmpty() && !phone.isEmpty()) {
                    intent.putExtra("Name", name);
                    intent.putExtra("Lastname", lastname);
                    intent.putExtra("Phone", phone);
                    startActivity(intent);
                }
            }
        });
    }
}
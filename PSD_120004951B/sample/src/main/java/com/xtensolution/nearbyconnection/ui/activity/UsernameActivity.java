package com.xtensolution.nearbyconnection.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.xtensolution.nearbyconnection.R;
import com.xtensolution.nearbyconnection.SampleApp;

public class UsernameActivity extends AppCompatActivity {

    Button switchToSecondActivity;
    SharedPreferences sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchToSecondActivity = findViewById(R.id.btnSubmit);
        switchToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPref = getSharedPreferences("pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                EditText txt = findViewById(R.id.inputUsername);
                editor.putString("username", txt.getText().toString());
                editor.commit();
                switchActivities();
            }
        });
    }


    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
}
package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView sharedresult;
    private final String key = String.valueOf(R.string.viewData);
    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button = findViewById(R.id.sendButton);
        sharedresult = findViewById(R.id.textViewName);

       myPreferenceRef = getPreferences(MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            openSecondActivity();
        }
    });
        }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("d22abdha", " startActivity");
        String defaultValue = "Nothing has been shared.";
        SharedPreferences sharedPref = getSharedPreferences(key, MODE_PRIVATE);
        sharedresult.setText(sharedPref.getString(key, defaultValue));
    }
    public void openSecondActivity() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

}







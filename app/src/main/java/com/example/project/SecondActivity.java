package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private final String key = String.valueOf(R.string.viewData);
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sharedPreferences = getSharedPreferences(key, MODE_PRIVATE);

        button = findViewById(R.id.sendButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeUserData();
                finish();
            }
        });

    }

    private void storeUserData() {
// Get the user input from the EditText view.
        EditText userInputEditText = findViewById(R.id.viewinput);
        String data = userInputEditText.getText().toString();

// Get an instance of the SharedPreferences object and create an editor.
        SharedPreferences.Editor editor = sharedPreferences.edit();

// Put the user input data into the editor with the given key.
        editor.putString(key, data);
        String key = "sharedPreferences";

// Commit the changes to the SharedPreferences.
        editor.apply();
    }
}
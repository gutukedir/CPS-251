package com.example.savedataproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nameInput;
    private LinearLayout namesContainer;
    private NamesViewModel namesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        namesContainer = findViewById(R.id.namesContainer);

        namesViewModel = new ViewModelProvider(this).get(NamesViewModel.class);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveName();
            }
        });

        displayNames(namesViewModel.getSavedNames());
    }

    private void saveName() {
        String enteredName = nameInput.getText().toString().trim();

        if (!enteredName.isEmpty()) {
            namesViewModel.addName(enteredName);

            displayNames(namesViewModel.getSavedNames());

            nameInput.getText().clear();
        } else {

            nameInput.setError("No name entered");
        }
    }

    private void displayNames(List<String> names) {
        namesContainer.removeAllViews();

        if (names.isEmpty()) {
            TextView noNameTextView = new TextView(this);
            noNameTextView.setText("No name entered");
            namesContainer.addView(noNameTextView);
        } else {

            for (String name : names) {
                TextView textView = new TextView(this);
                textView.setText(name);

                namesContainer.addView(textView);
            }
        }
    }
}

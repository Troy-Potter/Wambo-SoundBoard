package com.example.wambo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner dropDownMenu;
    Intent intent;
    Button createNewSoundboardButton;
    String boardSelection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Spinner
        dropDownMenu = findViewById(R.id.dropDownMenu);
        //Spinner value to string
        boardSelection = dropDownMenu.getSelectedItem().toString();
        createNewSoundboard();
    }

    /**
     * onClick method for launch button
     * Takes user to desired soundboard
     */
    /**
     * onClick method for launch button
     * Takes user to desired soundboard
     */
    public void chooseSoundboard(View v) {

        try {
            if (boardSelection.equals("Default Board")) {
                intent = new Intent(MainActivity.this, soundboardPage.class);
                this.startActivity(intent);

            } else if (boardSelection.equals("Custom Board 1")) {
                intent = new Intent(this, soundboardPageTwo.class);
                this.startActivity(intent);

            } else if (boardSelection.equals("Custom Board 2")) {
                intent = new Intent(this, soundboardPageThree.class);
                this.startActivity(intent);

            } else if (boardSelection.equals("Custom Board 3")) {
                intent = new Intent(this, soundboardPageFour.class);
                this.startActivity(intent);

            } else if (boardSelection.equals("Custom Board 4")) {
                intent = new Intent(this, soundboardPageFive.class);
                this.startActivity(intent);
            }
        } catch (Exception e) {
            Log.e("MyActivity::MyMethod", e.getMessage());
        }

    }

    /**
     * onClick method for 'Create new Soundboard' button
     * Directs user away from splash screen and makes new board
     */
    public void createNewSoundboard() {
        createNewSoundboardButton =findViewById(R.id.createNewSoundboardButton);
        createNewSoundboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = soundboardPage.createIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }



}

package com.example.wambo;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class soundboardPage extends AppCompatActivity implements PopupDialog.popupDialogListener{
    ArrayList<soundButton> buttonList;
    Button recordButton, changeSoundButton;
    String tempName, path;
    soundButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11
            , bt12, bt13, bt14, bt15, bt16;
    LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundboard_page);
        buttonList = new ArrayList<>();
        tempName = "";

        recordButton = findViewById(R.id.saveButton);
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent micIntent = new Intent(soundboardPage.this, micTest.class);
                startActivity(micIntent);
            }
        });


        // Each sound is put into a mediaPlayer
        MediaPlayer sound1 = MediaPlayer.create(this, R.raw.brekfast);
        MediaPlayer sound2 = MediaPlayer.create(this, R.raw.bruh);
        MediaPlayer sound3 = MediaPlayer.create(this, R.raw.chickens);
        MediaPlayer sound4 = MediaPlayer.create(this, R.raw.im_fine);
        MediaPlayer sound5 = MediaPlayer.create(this, R.raw.raw);
        MediaPlayer sound6 = MediaPlayer.create(this, R.raw.run);
        MediaPlayer sound7 = MediaPlayer.create(this, R.raw.twentyone);
        MediaPlayer sound8 = MediaPlayer.create(this, R.raw.vodka);
        MediaPlayer sound9 = MediaPlayer.create(this, R.raw.wam);
        MediaPlayer sound10 = MediaPlayer.create(this, R.raw.wednesday);
        MediaPlayer sound11 = MediaPlayer.create(this, R.raw.damnson);
        MediaPlayer sound12 = MediaPlayer.create(this, R.raw.justdoit);
        MediaPlayer sound13 = MediaPlayer.create(this, R.raw.memereview);
        MediaPlayer sound14 = MediaPlayer.create(this, R.raw.nogod);
        MediaPlayer sound15 = MediaPlayer.create(this, R.raw.profanity);
        MediaPlayer sound16 = MediaPlayer.create(this, R.raw.wasted);


        // Layout rows are initialized
        linearLayout1 = findViewById(R.id.linearLayout1);
        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout3 = findViewById(R.id.linearLayout3);
        linearLayout4 = findViewById(R.id.linearLayout4);

        // Buttons are initialized and given sounds/names
        bt1 = new soundButton(this, "brek", sound1);
        bt2 = new soundButton(this, "bruh", sound2);
        bt3 = new soundButton(this, "chik", sound3);
        bt4 = new soundButton(this, "fine", sound4);

        bt5 = new soundButton(this, "raw", sound5);
        bt6 = new soundButton(this, "run", sound6);
        bt7 = new soundButton(this, "21", sound7);
        bt8 = new soundButton(this, "vodka", sound8);

        bt9 = new soundButton(this, "wam", sound9);
        bt10 = new soundButton(this, "wed", sound10);
        bt11 = new soundButton(this, "damn", sound11);
        bt12 = new soundButton(this, "doIT", sound12);

        bt13 = new soundButton(this, "meme", sound13);
        bt14 = new soundButton(this, "noGod", sound14);
        bt15 = new soundButton(this, "prof", sound15);
        bt16 = new soundButton(this, "wasted", sound16);

        // First row of buttons
        linearLayout1.addView(bt1);
        linearLayout1.addView(bt2);
        linearLayout1.addView(bt3);
        linearLayout1.addView(bt4);

        // Second row of buttons
        linearLayout2.addView(bt5);
        linearLayout2.addView(bt6);
        linearLayout2.addView(bt7);
        linearLayout2.addView(bt8);

        // Third row of buttons
        linearLayout3.addView(bt9);
        linearLayout3.addView(bt10);
        linearLayout3.addView(bt11);
        linearLayout3.addView(bt12);

        // Fourth row of buttons
        linearLayout4.addView(bt13);
        linearLayout4.addView(bt14);
        linearLayout4.addView(bt15);
        linearLayout4.addView(bt16);

        List<soundButton> buttonArray = Arrays.asList(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16);
        buttonList.addAll(buttonArray);

        longClickListeners();
    }

    public void changeSound(View view) {
        EditText fileNameET = findViewById(R.id.fileName);
        EditText buttonNumberET = findViewById(R.id.buttonNumber);
        int buttonNumber = Integer.parseInt(buttonNumberET.getText().toString()) - 1;
        if(buttonNumber <= 0 || buttonNumber >16) {
            buttonNumber = 0;
        }
        buttonNumberET.setHint("" + buttonNumber);
        MediaPlayer sound100 = new MediaPlayer();
        path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" +
                fileNameET.getText() + ".mp3";
        try {
            sound100.setDataSource(path);
            sound100.prepare();
            buttonList.get(buttonNumber).setSound(sound100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * initiates the AlertDialog
     */
    public void openDialog() {
        PopupDialog popupDialog = new PopupDialog();
        popupDialog.show(getSupportFragmentManager(), "popup dialog");

    }

    /**
     * Method to open page
     * @param context
     * @return
     */
    public static Intent createIntent(Context context) {
        return new Intent(context, soundboardPage.class);
    }

    /**
     * returned method from alert dialog, allowing to change the label on a button
     * @param buttonName - returned string from AlertDialog
     */
    @Override
    public void applyTexts(String buttonName) {

        tempName = buttonName;

    }

    /**
     * Sets up all OnLongClickListeners for 16 buttons
     */
    public void longClickListeners() {

        for(soundButton b : buttonList) {
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(tempName.equals("")) {
                        tempName = ((soundButton)v).getText().toString();
                    }
                    openDialog();

                    ((soundButton)v).setName(tempName);
                    tempName = ((soundButton)v).getText().toString();
                    return false;
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate Menu
        getMenuInflater().inflate(R.menu.helpmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Get selected item id
        int id = item.getItemId();
        //Compare id for action
        if (id == R.id.help){

            //Setup alert Builder
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Help");
            builder.setMessage("Short Press a button to play the sound.\n\nLong Press the button to change the button label\n\nPress the Record button to record custom sounds\n\nEnter the name of your sound file (without the extension), and enter the position you want it in (1-16)\n\nClicking the arrow at the top will direct you home.");

            //Add button
            builder.setPositiveButton("Ok", null);

            //Create and show dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

}

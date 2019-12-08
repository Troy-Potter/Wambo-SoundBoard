package com.example.wambo;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class soundboardPageFive extends AppCompatActivity implements PopupDialog.popupDialogListener{
    ArrayList<soundButton> buttonList;
    Button saveButton;
    String tempName;
    soundButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11
            , bt12, bt13, bt14, bt15, bt16;
    LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundboard_page);
        buttonList = new ArrayList<>();

        List<soundButton> buttonArray = Arrays.asList(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16);
        buttonList.addAll(buttonArray);
        tempName = "";

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

        longClickListeners();

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
        return new Intent(context, soundboardPageFive.class);
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

        bt1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt1.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt2.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt3.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt4.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt5.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt6.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt7.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt8.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt9.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt10.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt11.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt11.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt12.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt12.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt13.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt13.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt14.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt14.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt15.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt15.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });

        bt16.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tempName.equals("")) {
                    tempName = ((soundButton)v).getText().toString();
                }
                openDialog();

                bt16.setName(tempName);
                tempName = ((soundButton)v).getText().toString();
                return false;
            }
        });



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
            builder.setMessage("Short Press a button to play the sound.\n\nLong Press the button to change the button sound with a sound file or record your voice\n\nClicking the arrow at the top will direct you home.");

            //Add button
            builder.setPositiveButton("Ok", null);

            //Create and show dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

}

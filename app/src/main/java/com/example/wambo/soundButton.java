package com.example.wambo;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.v4.app.Fragment;




public class soundButton extends android.support.v7.widget.AppCompatButton {

    public soundButton(Context context, String name, MediaPlayer mediaPlayer) {
        super(context);
        setName(name);
        setSound(mediaPlayer);
        setLongClick();
    }

    public void setSound(final MediaPlayer mediaPlayer) {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
    }

    public void setLongClick() {
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }

    public void setName(String name) {
        setText(name);
    }


}

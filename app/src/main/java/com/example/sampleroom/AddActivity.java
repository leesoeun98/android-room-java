package com.example.sampleroom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    private MusicDB musicDB = null;
    private Context mContext;
    private EditText mEditTextTitle;
    private EditText mEditTextSinger;
    private EditText mEditTextPlayTime;
    private EditText mEditTextLyrics;
    private Button mAddButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mAddButton = (Button) findViewById(R.id.mAddItemButton);
        mEditTextTitle = (EditText) findViewById(R.id.mEditTextTitle);
        mEditTextSinger = (EditText) findViewById(R.id.mEditTextSinger);
        mEditTextPlayTime = (EditText) findViewById(R.id.mEditTextPlayTime);
        mEditTextLyrics = (EditText) findViewById(R.id.mEditTextLyrics);

        musicDB = MusicDB.getInstance(this);
        mContext = getApplicationContext();

        class InsertRunnable implements Runnable {

            @Override
            public void run() {
               Music music = new Music();
               music.title = mEditTextTitle.getText().toString();
               music.singer = mEditTextSinger.getText().toString();
               music.playTime = Long.parseLong(mEditTextPlayTime.getText().toString());
               music.lyrics = mEditTextLyrics.getText().toString();
               MusicDB.getInstance(mContext).musicDao().insertAll(music);
            }
        }

        mAddButton.setOnClickListener(v -> {

            InsertRunnable insertRunnable = new InsertRunnable();
            Thread addThread = new Thread(insertRunnable);
            addThread.start();

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();

        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MusicDB.destroyInstance();
    }
}

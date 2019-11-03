package com.example.beats;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayingNowActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playing_activity);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            int currentPlaying = extras.getInt(MainActivity.KEY_POSITION);
            CustomSongArrayList nowPlayingSong = MainActivity.mMusicData.get(currentPlaying);

            TextView textView = findViewById(R.id.now_playing_song_name);
            textView.setText(nowPlayingSong.getSongName());

            ImageView imageView = findViewById(R.id.now_playing_song_image);
            imageView.setImageResource(nowPlayingSong.getImageId());

            textView = findViewById(R.id.now_playing_song_artist);
            textView.setText(nowPlayingSong.getArtistName());

            textView = findViewById(R.id.now_playing_song_album);
            textView.setText(nowPlayingSong.getAlbumName());
        }
    }
}


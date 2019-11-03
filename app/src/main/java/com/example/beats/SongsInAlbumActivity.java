package com.example.beats;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class SongsInAlbumActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_songs);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            LinearLayout ll = findViewById(R.id.songs_in_album);
            int position = extras.getInt(MainActivity.KEY_POSITION);
            String albumName = extras.getString(MainActivity.KEY_ALBUMNAME);

            TextView textViewAlbum = new TextView(this);
            textViewAlbum.setText(albumName);
            textViewAlbum.setTextAppearance(this, android.R.style.TextAppearance_Large);
            textViewAlbum.setTypeface(null, Typeface.BOLD);
            textViewAlbum.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            textViewAlbum.setPadding(0,32,0,48);
            ll.addView(textViewAlbum);

            LinearLayout.LayoutParams linearLayout = new LinearLayout.LayoutParams(500,500);
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(MainActivity.mAlbumData.get(position).getImageId());
            imageView.setLayoutParams(linearLayout);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setAdjustViewBounds(true);
            linearLayout.gravity = Gravity.CENTER_HORIZONTAL;
            ll.addView(imageView);

            for(int i=0; i<MainActivity.mMusicData.size();i++){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    if(Objects.equals(albumName, MainActivity.mMusicData.get(i).getAlbumName())){

                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.setMargins(32,26,32,16);
                        TextView textView = new TextView(this);
                        textView.setText(MainActivity.mMusicData.get(i).getSongName());
                        textView.setTextAppearance(this, android.R.style.TextAppearance_Medium);
                        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                        textView.setPadding(0,32,0,32);
                        textView.setBackgroundResource(R.drawable.background_border);
                        textView.setLayoutParams(params);
                        textView.setClickable(true);
                        textView.setFocusable(true);
                        ll.addView(textView);

                        final int songPosition = i;
                        textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(SongsInAlbumActivity.this,PlayingNowActivity.class);
                                intent.putExtra(MainActivity.KEY_POSITION, songPosition);
                                startActivity(intent);
                            }
                        });
                    }
                }
            }
        }
    }

}

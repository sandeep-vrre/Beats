package com.example.beats;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    public static ArrayList<CustomSongArrayList> mMusicData;
    public static ArrayList<CustomAlbumArrayList> mAlbumData;
    public static final String KEY_POSITION = "position";
    public static final String KEY_ALBUMNAME = "albumName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mMusicData will hold CustomSongArrayList in each cell.
        // Each CustomSongArrayList contains Song Image, Song Name, Artist Name, Album Name as data
        mMusicData = new ArrayList<>();
        mMusicData.add(new CustomSongArrayList(R.drawable.marshmello,getString(R.string.song_happier),getString(R.string.artist_Christopher_Comstock),getString(R.string.album_marshmellow)));
        mMusicData.add(new CustomSongArrayList(R.drawable.alanwalker_hits,getString(R.string.song_darkside),getString(R.string.artist_alan_walker),getString(R.string.album_alan_walker_hits)));
        mMusicData.add(new CustomSongArrayList(R.drawable.syko_beats,getString(R.string.song_cool_catz),getString(R.string.artist_syko_beats),getString(R.string.album_syko)));
        mMusicData.add(new CustomSongArrayList(R.drawable.ashes_remain,getString(R.string.song_on_my_own),getString(R.string.artist_ashes_remain),getString(R.string.album_what_i_have_become)));
        mMusicData.add(new CustomSongArrayList(R.drawable.thefatrat,getString(R.string.song_monody),getString(R.string.artist_christian),getString(R.string.album_thefatrat)));
        mMusicData.add(new CustomSongArrayList(R.drawable.deamn, getString(R.string.song_sign),getString(R.string.artist_alan_walker),getString(R.string.album_deamn_hits)));
        mMusicData.add(new CustomSongArrayList(R.drawable.ashes_remain,getString(R.string.song_right_here),getString(R.string.artist_ashes_remain),getString(R.string.album_what_i_have_become)));
        mMusicData.add(new CustomSongArrayList(R.drawable.ehide,getString(R.string.song_ehide_myheart),getString(R.string.artist_Ehide),getString(R.string.album_my_heart)));
        mMusicData.add(new CustomSongArrayList(R.drawable.deamn,getString(R.string.song_save_me),getString(R.string.artist_alan_walker),getString(R.string.album_deamn_hits)));
        mMusicData.add(new CustomSongArrayList(R.drawable.alanwalker_hits,getString(R.string.song_the_spectre),getString(R.string.artist_alan_walker),getString(R.string.album_alan_walker_hits)));
        mMusicData.add(new CustomSongArrayList(R.drawable.cloud_ten,getString(R.string.song_cloud_ten),getString(R.string.artist_Fareoh),getString(R.string.album_cloud_ten_singles)));
        mMusicData.add(new CustomSongArrayList(R.drawable.alanwalker_hits,getString(R.string.song_darkness_fade),getString(R.string.artist_alan_walker),getString(R.string.album_alan_walker_hits)));
        mMusicData.add(new CustomSongArrayList(R.drawable.casting_crowns,getString(R.string.song_nxt_thng),getString(R.string.artist_casting_crows),getString(R.string.album_thenxt)));
        mMusicData.add(new CustomSongArrayList(R.drawable.thefatrat,getString(R.string.song_unity),getString(R.string.artist_christian),getString(R.string.album_thefatrat)));
        mMusicData.add(new CustomSongArrayList(R.drawable.cloud_ten,getString(R.string.song_under_water),getString(R.string.artist_fareoh_thompson),getString(R.string.album_cloud_ten_singles)));
        mMusicData.add(new CustomSongArrayList(R.drawable.alanwalker_hits,getString(R.string.song_on_my_way),getString(R.string.artist_alan_walker),getString(R.string.album_alan_walker_hits)));
        mMusicData.add(new CustomSongArrayList(R.drawable.syko_beats,getString(R.string.song_old_school),getString(R.string.artist_syko_beats),getString(R.string.album_syko)));
        mMusicData.add(new CustomSongArrayList(R.drawable.ashes_remain,getString(R.string.song_change_my_life),getString(R.string.artist_ashes_remain),getString(R.string.album_what_i_have_become)));
        mMusicData.add(new CustomSongArrayList(R.drawable.casting_crowns,getString(R.string.song_one_step_away),getString(R.string.artist_casting_crows),getString(R.string.album_thenxt)));
        mMusicData.add(new CustomSongArrayList(R.drawable.ashes_remain,getString(R.string.song_without_you),getString(R.string.artist_ashes_remain),getString(R.string.album_what_i_have_become)));

        // Album Data & No of Songs in album
        mAlbumData = new ArrayList<>();
        mAlbumData.add(new CustomAlbumArrayList(R.drawable.alanwalker_hits,getString(R.string.album_alan_walker_hits),4));
        mAlbumData.add(new CustomAlbumArrayList(R.drawable.deamn,getString(R.string.album_deamn_hits),2));
        mAlbumData.add(new CustomAlbumArrayList(R.drawable.ashes_remain,getString(R.string.album_what_i_have_become),4));
        mAlbumData.add(new CustomAlbumArrayList(R.drawable.marshmello,getString(R.string.album_marshmellow),1));
        mAlbumData.add(new CustomAlbumArrayList(R.drawable.syko_beats,getString(R.string.album_syko),2));
        mAlbumData.add(new CustomAlbumArrayList(R.drawable.casting_crowns,getString(R.string.album_what_i_have_become),2));
        mAlbumData.add(new CustomAlbumArrayList(R.drawable.eyeonit,getString(R.string.album_eye_on_it),2));
        mAlbumData.add(new CustomAlbumArrayList(R.drawable.thefatrat,getString(R.string.album_thefatrat),2));
        mAlbumData.add(new CustomAlbumArrayList(R.drawable.cloud_ten,getString(R.string.album_cloud_ten_singles),2));
        mAlbumData.add(new CustomAlbumArrayList(R.drawable.ehide,getString(R.string.album_my_heart),1));


        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(MainActivity.this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}

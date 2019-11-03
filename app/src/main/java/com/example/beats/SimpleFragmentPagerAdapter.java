package com.example.beats;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SimpleFragmentPagerAdapter  extends FragmentStatePagerAdapter{

    private Context mContext;
    SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return new SongsFragment();
        else
            return new AlbumsFragment();
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 2;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.title_songs);
            case 1:
                return mContext.getString(R.string.title_albums);
            default:
                return null;
        }
    }
}

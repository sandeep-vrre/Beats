package com.example.beats;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SongsFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_activity, container, false);

        CustomSongArrayAdapter customArrayAdapter = new CustomSongArrayAdapter(getActivity(),MainActivity.mMusicData);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(customArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getContext(),PlayingNowActivity.class);
                intent.putExtra(MainActivity.KEY_POSITION,position);
                startActivity(intent);
            }
        });
        return rootView;
    }

}

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

public class AlbumsFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_activity, container, false);

        CustomAlbumArrayAdapter customArrayAdapter = new CustomAlbumArrayAdapter(getContext(),MainActivity.mAlbumData);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(customArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                CustomAlbumArrayList currentAlbum = MainActivity.mAlbumData.get(position);
                String currentAlbumName = currentAlbum.getAlbumName();
                Intent intent = new Intent(getContext(),SongsInAlbumActivity.class);
                intent.putExtra(MainActivity.KEY_POSITION, position);
                intent.putExtra(MainActivity.KEY_ALBUMNAME, currentAlbumName);
                startActivity(intent);
            }
        });
        return rootView;
    }
}

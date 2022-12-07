package com.freesongs.musikplayer8.Music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.freesongs.musikplayer8.DAO.DaoMusic;
import com.freesongs.musikplayer8.Model.Songs;
import com.freesongs.musikplayer8.R;

import java.util.ArrayList;

public class FragmentMusic extends Fragment {

    ImageButton tien , lui , play ;
    SeekBar seekBar ;
    TextView tenbh;

    DaoMusic daoMusic = new DaoMusic(getContext());
    ArrayList<Songs> list = daoMusic.getDSbaihat();
    MediaPlayer mediaPlayer;

    int i = 0 ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_music , container , false );

        tien = view.findViewById(R.id.tien);
        lui = view.findViewById(R.id.lui);
        play = view.findViewById(R.id.play);
        seekBar = view.findViewById(R.id.seekBar);
        tenbh = view.findViewById(R.id.tenbh);

        goimedia(i);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.play);
                }
                else {
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.pause);
                }

            }
        });

        tien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if(i > 3){
                    i = 0;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                goimedia(i);
                mediaPlayer.start();
            }
        });

        lui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                if(i < 0){
                    i = 3;

                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                goimedia(i);
                mediaPlayer.start();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });



        return view;
    }

    private void goimedia(int i){
        mediaPlayer = MediaPlayer.create(getContext(), Integer.parseInt(list.get(i).getFile()));
        tenbh.setText(list.get(i).getTenbaihat());
    }

}

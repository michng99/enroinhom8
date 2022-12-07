package com.freesongs.musikplayer8.Music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.freesongs.musikplayer8.DAO.DaoBXH;
import com.freesongs.musikplayer8.Model.Songs;
import com.freesongs.musikplayer8.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FragmentPlay extends Fragment {

    TextView tenbh , tentg , realtime , timemax ;
    ImageView dianhac ;
    SeekBar seekBar ;
    ImageButton lui , tien , play ;
    MediaPlayer mediaPlayer;
    DaoBXH daoBXH ;
    ArrayList<Songs> list ;
    Animation animation;
    int a = 0 ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play, container,false);

        tenbh = view.findViewById(R.id.tenbh);
        tentg = view.findViewById(R.id.tentg);
        dianhac = view.findViewById(R.id.dianhac);
        seekBar = view.findViewById(R.id.seekBar);
        lui = view.findViewById(R.id.lui);
        tien = view.findViewById(R.id.tien);
        play = view.findViewById(R.id.play);
        realtime = view.findViewById(R.id.realtime);
        timemax = view.findViewById(R.id.timemax);

        animation = AnimationUtils.loadAnimation(getContext(),R.anim.xoaydia);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        daoBXH = new DaoBXH(getContext());
        list = daoBXH.getBXH();

        int b = list.size();

        goimedia(a);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.play);
                    dianhac.clearAnimation();

                }
                else {
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.pause);
                    dianhac.startAnimation(animation);
                }
                settimetong();
                capnhatthoigian();
            }
        });

        tien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                if(a == b){
                    a = 0;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                goimedia(a);
                play.setImageResource(R.drawable.pause);
                dianhac.startAnimation(animation);
                mediaPlayer.start();
                settimetong();
                capnhatthoigian();
            }
        });

        lui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a--;
                if(a < 0){
                    a = b - 1;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                goimedia(a);
                play.setImageResource(R.drawable.pause);
                dianhac.startAnimation(animation);
                mediaPlayer.start();
                settimetong();
                capnhatthoigian();
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


    }

    private void goimedia(int i){
            mediaPlayer = MediaPlayer.create(getContext(), getContext().getResources().getIdentifier(list.get(i).getFile(),"raw",getContext().getPackageName()));
            tenbh.setText(list.get(i).getTenbaihat());
            tentg.setText(list.get(i).getTentacgia());
            dianhac.setImageResource(getContext().getResources().getIdentifier(list.get(i).getHinhanh(),"drawable",getContext().getPackageName()));
    }

    private void settimetong(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        timemax.setText(simpleDateFormat.format(new Date(mediaPlayer.getDuration())));
        seekBar.setMax(mediaPlayer.getDuration());
    }

    private void capnhatthoigian(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                realtime.setText(simpleDateFormat.format(new Date(mediaPlayer.getCurrentPosition())));

                seekBar.setProgress(mediaPlayer.getCurrentPosition());

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        a++;
                        if(a == list.size()){
                            a = 0;
                        }
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        goimedia(a);
                        mediaPlayer.start();
                        settimetong();
                        capnhatthoigian();
                    }
                });

                handler.postDelayed(this,500);
            }
        } , 100);
    }

}

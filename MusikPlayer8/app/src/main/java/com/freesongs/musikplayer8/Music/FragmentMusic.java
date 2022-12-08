package com.freesongs.musikplayer8.Music;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.freesongs.musikplayer8.Adapter.AdapterBXH;
import com.freesongs.musikplayer8.DAO.DaoBXH;
import com.freesongs.musikplayer8.Model.Songs;
import com.freesongs.musikplayer8.R;
import java.util.ArrayList;

public class FragmentMusic extends Fragment {
    RecyclerView recyvlerviewbxh;
    ImageButton timkiem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);

        timkiem = view.findViewById(R.id.timkiem);
        recyvlerviewbxh = view.findViewById(R.id.recyvlerviewbxh);
        DaoBXH daoBXH = new DaoBXH(getContext());
        ArrayList<Songs> list = daoBXH.getBXH();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyvlerviewbxh.setLayoutManager(linearLayoutManager);
        AdapterBXH adapterBXH = new AdapterBXH(getContext(),list);
        recyvlerviewbxh.setAdapter(adapterBXH);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyvlerviewbxh.addItemDecoration(itemDecoration);

        timkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Search.class);
                startActivity(intent);

            }
        });




        return view;
    }


}

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        daoMusic = new DaoMusic(getContext());
//        list = daoMusic.getDSbaihat();
//        goimedia(i);
//
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mediaPlayer.isPlaying()){
//                    mediaPlayer.pause();
//                    play.setImageResource(R.drawable.play);
//                }
//                else {
//                    mediaPlayer.start();
//                    play.setImageResource(R.drawable.pause);
//                }
//                seekBar.setMax(mediaPlayer.getDuration());
//                capnhatthoigian();
//            }
//        });
//
//        tien.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                i++;
//                if(i > 3){
//                    i = 0;
//                }
//                if (mediaPlayer.isPlaying()){
//                    mediaPlayer.stop();
//                }
//                goimedia(i);
//                mediaPlayer.start();
//                seekBar.setMax(mediaPlayer.getDuration());
//                capnhatthoigian();
//            }
//        });
//
//        lui.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                i--;
//                if(i < 0){
//                    i = 3;
//
//                }
//                if (mediaPlayer.isPlaying()){
//                    mediaPlayer.stop();
//                }
//                goimedia(i);
//                mediaPlayer.start();
//                seekBar.setMax(mediaPlayer.getDuration());
//                capnhatthoigian();
//            }
//        });
//
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                mediaPlayer.seekTo(seekBar.getProgress());
//            }
//        });
//
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        goimedia(i);
//    }
//
//    private void goimedia(int i){
//        try {
//            mediaPlayer = MediaPlayer.create(getContext(), getContext().getResources().getIdentifier(list.get(i).getFile(),"raw",getContext().getOpPackageName()));
//            tenbh.setText(list.get(i).getTenbaihat());
//        }catch (Exception e)
//        {
//
//        }
//
//    }
//
//    private void capnhatthoigian(){
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                seekBar.setProgress(mediaPlayer.getCurrentPosition());
//
//                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mp) {
//                        i++;
//                        if(i > 3){
//                            i = 0;
//                        }
//                        if (mediaPlayer.isPlaying()){
//                            mediaPlayer.stop();
//                        }
//                        goimedia(i);
//                        mediaPlayer.start();
//                        capnhatthoigian();
//                    }
//                });
//
//                handler.postDelayed(this,500);
//            }
//        } , 100);
//    }



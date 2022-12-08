package com.freesongs.musikplayer8.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.freesongs.musikplayer8.R;
import com.freesongs.musikplayer8.model.Playlists;
import com.freesongs.musikplayer8.model.Songs;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder>
{
    Context context ;
    private ArrayList<Playlists> playlist;

    public PlaylistAdapter(Context context, ArrayList<Playlists> playlist) {
        this.context = context;
        this.playlist = playlist;
    }


    @NonNull
    @Override
    public PlaylistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.playlist_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(playlist.get(position).getImgPath()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return playlist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView tv1, tv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.imageView2);
            tv1 = itemView.findViewById(R.id.tenDSP);
            tv2 = itemView.findViewById(R.id.demBaiHatDSP);

        }
    }
}

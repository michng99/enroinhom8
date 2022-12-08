package com.freesongs.musikplayer8.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freesongs.musikplayer8.DAO.DaoGetAllSongs;
import com.freesongs.musikplayer8.R;
import com.freesongs.musikplayer8.model.Songs;

import java.util.ArrayList;

public class GetAllSongAdapter extends RecyclerView.Adapter<GetAllSongAdapter.ViewHolder>{

    DaoGetAllSongs daoGetAllSongs;
    Context context ;
    private ArrayList<Songs> list;
    int loai;

    public GetAllSongAdapter(Context context, ArrayList<Songs> list,int loai) {
        this.context = context;
        this.list = list;
        this.loai= loai;
        daoGetAllSongs = new DaoGetAllSongs(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.item_getall, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Songs songs = list.get(position);
        if (loai==1){
            holder.tv_getall.setText(songs.getTenbaihat());
            holder.btn_getall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (daoGetAllSongs.insertBH(songs)){
                        Toast.makeText(v.getContext(), "đã thêm "+songs.getTenbaihat()+" thành công", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(v.getContext(), "đã thêm "+songs.getTenbaihat()+" thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else{
//            holder.btn_getall.setVisibility(View.GONE);
            holder.btn_getall.setText("xóa");
            holder.tv_getall.setText(songs.getTenbaihat());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_getall;
        Button btn_getall;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_getall = itemView.findViewById(R.id.tv_getall);
            btn_getall = itemView.findViewById(R.id.btn_getall);
        }
    }

}

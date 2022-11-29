package com.freesongs.musikplayer8.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freesongs.musikplayer8.R;
import com.freesongs.musikplayer8.model.BaiHat;

import java.util.List;


public class BaiHatAdapter extends RecyclerView.Adapter<BaiHatAdapter.BaiHatViewHolder>
{


//    BaiHat data[]; (volley)
//
//    public BaiHatAdapter(BaiHat[] data) {
//        this.data = data;
//    }


    private List<BaiHat> dSBH;
    Context context;

    public BaiHatAdapter(List<BaiHat> dSBH) {
        this.dSBH = dSBH;
    }




    @NonNull
    @Override
    public BaiHatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new BaiHatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaiHatViewHolder holder, int position) {
//        holder.t1.setText(data[position].getTenbaihat()); (volley)
//        holder.t2.setText(data[position].getTacgia());
//        holder.t1.setText(data[position].getBaihat());
//        holder.t1.setText(data[position].getHinhanh());
//        holder.t1.setText(data[position].getThoiluong());

        holder.t1.setText(dSBH.get(position).getTenbaihat());
        holder.t2.setText(dSBH.get(position).getTacgia());
        holder.t3.setText(dSBH.get(position).getBaihat());
        holder.t4.setText(dSBH.get(position).getHinhanh());
        holder.t5.setText(dSBH.get(position).getThoiluong());

        
    }

    @Override
    public int getItemCount() {
        return dSBH.size();
    }

    class BaiHatViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView t1, t2, t3, t4, t5, t6;
        public BaiHatViewHolder(@NonNull View itemView)
        {
            super(itemView);

            img = itemView.findViewById(R.id.im1);
            t1 = itemView.findViewById(R.id.tv1);
            t2 = itemView.findViewById(R.id.tv2);
            t3 = itemView.findViewById(R.id.tv3);
            t4 = itemView.findViewById(R.id.tv4);
            t5 = itemView.findViewById(R.id.tv5);

        }
    }
}

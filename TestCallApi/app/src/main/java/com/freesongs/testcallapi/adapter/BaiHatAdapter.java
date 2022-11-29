package com.freesongs.testcallapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freesongs.testcallapi.R;
import com.freesongs.testcallapi.model.BaiHat;

public class BaiHatAdapter extends RecyclerView.Adapter<BaiHatAdapter.BaiHatViewHolder>{

    BaiHat data[];
    Context context;

    public BaiHatAdapter(BaiHat[] data, Context context)
    {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public BaiHatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new BaiHatViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BaiHatViewHolder holder, int position)
    {
        BaiHat bh = data[position];
        holder.t1.setText(bh.getTenbaihat());
        holder.t2.setText(bh.getTacgia());
        holder.t3.setText(bh.getBaihat());
        holder.t4.setText(bh.getHinhanh());
        holder.t5.setText(bh.getThoiluong());
//        Glide.with(holder.img.getContext()).load()
    }

    @Override
    public int getItemCount() {
        return data.length;
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


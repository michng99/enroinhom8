package com.freesongs.musikplayer8.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.freesongs.musikplayer8.ClickBXH;
import com.freesongs.musikplayer8.Model.Songs;
import com.freesongs.musikplayer8.Music.ChoiNhac;
import com.freesongs.musikplayer8.R;
import java.util.ArrayList;

public class AdapterBXH extends RecyclerView.Adapter<AdapterBXH.ViewHolder> {

    Context context ;
    private ArrayList<Songs> list;

    public AdapterBXH(Context context, ArrayList<Songs> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_bxh,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imvbxh.setImageResource(context.getResources().getIdentifier(list.get(position).getHinhanh(),"drawable",context.getPackageName()));
        holder.tenbaihatbxh.setText(list.get(position).getTenbaihat());
        holder.tentacgiabxh.setText(list.get(position).getTentacgia());

        holder.setItemclick(new ClickBXH() {
            @Override
            public void onItemClick(View view, int i) {
                Toast.makeText(context, "dang chon  "+(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ChoiNhac.class);
                intent.putExtra("position", holder.getAdapterPosition());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView tenbaihatbxh , tentacgiabxh ;
        ImageView imvbxh;
        public ClickBXH clickBXH;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvbxh = itemView.findViewById(R.id.imvbxh);
            tenbaihatbxh = itemView.findViewById(R.id.tenbaihatbxh);
            tentacgiabxh = itemView.findViewById(R.id.tentacgiabxh);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.clickBXH.onItemClick(v,getAdapterPosition());
        }

        public void setItemclick(ClickBXH clickBXH){
            this.clickBXH = clickBXH;
        }


    }
}

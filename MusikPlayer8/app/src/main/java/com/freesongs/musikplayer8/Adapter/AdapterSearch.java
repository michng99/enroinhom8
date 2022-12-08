package com.freesongs.musikplayer8.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
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

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.ViewHolder> implements Filterable {

    Context context ;
    private ArrayList<Songs> list;
    private ArrayList<Songs> listbxh;


    public AdapterSearch(Context context, ArrayList<Songs> list) {
        this.context = context;
        this.list = list;
        this.listbxh = list;
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
                ((Activity)context).finish();

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String strSearch = charSequence.toString();
                if (strSearch.isEmpty()){
                    list = listbxh;
                } else {
                    ArrayList<Songs> listt = new ArrayList<>();
                    for (Songs songs: listbxh ){
                        if(songs.getTenbaihat().toLowerCase().contains(strSearch.toLowerCase())){
                            listt.add(songs);
                        }
                    }
                    list = listt;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = list;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                list = (ArrayList<Songs>) filterResults.values;
                notifyDataSetChanged();
            }
        };
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

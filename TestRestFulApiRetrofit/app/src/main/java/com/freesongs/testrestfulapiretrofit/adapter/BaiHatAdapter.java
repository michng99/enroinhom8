package com.freesongs.testrestfulapiretrofit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freesongs.testrestfulapiretrofit.R;
import com.freesongs.testrestfulapiretrofit.model.BaiHat;

import java.util.List;

public class BaiHatAdapter extends RecyclerView.Adapter<BaiHatAdapter.BaiHatViewHolder> {


    private List<BaiHat> danhSachBaiHat;

    public BaiHatAdapter(List<BaiHat> danhSachBaiHat) {
        this.danhSachBaiHat = danhSachBaiHat;
    }

    @NonNull
    @Override
    public BaiHatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.baihatrow_layout, parent, false);
        return new BaiHatViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BaiHatViewHolder holder, int position) {

        //ket noi textview de set ten
        holder.tenbaihattv.setText(danhSachBaiHat.get(position).getTenbaihat());
        holder.tacgiatv.setText(danhSachBaiHat.get(position).getTacgia());
        holder.urlbaihattv.setText(danhSachBaiHat.get(position).getBaihaturl());
        holder.hinhanhtv.setText(danhSachBaiHat.get(position).getHinhanh());
        holder.thoiluongtv.setText(danhSachBaiHat.get(position).getThoiluong());
    }

    @Override
    public int getItemCount() {
        return danhSachBaiHat.size();
    }

    public class BaiHatViewHolder extends RecyclerView.ViewHolder {

        TextView tenbaihattv, tacgiatv, urlbaihattv, hinhanhtv, thoiluongtv;

        public BaiHatViewHolder(@NonNull View itemView) {
            super(itemView);

            tenbaihattv = itemView.findViewById(R.id.tenBaiHat);
            tacgiatv = itemView.findViewById(R.id.tacGia);
            urlbaihattv = itemView.findViewById(R.id.baiHatURL);
            hinhanhtv = itemView.findViewById(R.id.hinhAnh);
            thoiluongtv = itemView.findViewById(R.id.thoiLuong);

        }
    }



}

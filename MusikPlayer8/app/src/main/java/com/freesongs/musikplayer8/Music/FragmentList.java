package com.freesongs.musikplayer8.Music;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.freesongs.musikplayer8.Adapter.AdapterBXH;
import com.freesongs.musikplayer8.DAO.DaoBXH;
import com.freesongs.musikplayer8.model.Songs;
import com.freesongs.musikplayer8.R;

import java.util.ArrayList;

public class FragmentList extends Fragment {
    RecyclerView rcrplay;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container,false);

        rcrplay = view.findViewById(R.id.rcrplay);
        DaoBXH daoBXH = new DaoBXH(getContext());
        ArrayList<Songs> list = daoBXH.getBXH();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcrplay.setLayoutManager(linearLayoutManager);
        AdapterBXH adapterBXH = new AdapterBXH(getContext(),list);
        rcrplay.setAdapter(adapterBXH);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        rcrplay.addItemDecoration(itemDecoration);

        return view;
    }
}

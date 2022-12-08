package com.freesongs.musikplayer8.Helper;

import androidx.recyclerview.widget.GridLayoutManager;

public class SpanSizeLookupPlaylist extends GridLayoutManager.SpanSizeLookup {

    int spanPos;
    int spanCount1;
    int spanCount2;

    public SpanSizeLookupPlaylist(int spanPos, int spanCount1, int spanCount2) {
        this.spanCount1 = spanCount1;
        this.spanCount2 = spanCount2;
        this.spanPos = spanPos;
    }

    @Override
    public int getSpanSize(int position) {
        return (position % spanPos == 0 ? spanCount2:spanCount1);
    }
}

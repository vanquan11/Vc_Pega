package com.example.vc_pega.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SplitRcv extends RecyclerView.OnScrollListener {
    private int coll = 0;
    private boolean check = true;

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (!recyclerView.canScrollVertically(-1)){
            normal();
            check = true;
        }

        if (coll > Typess.ht && check && recyclerView.canScrollVertically(-1)){
            hide();
            check = false;
        }

        if (recyclerView.canScrollVertically(-1)){
            show();
            check = false;
        }

        if ((check && dy > 0) || (!check && dy < 0)) {
            alpha();
            coll += dy;
        }

    }

    public abstract void hide();
    public abstract void show();
    public abstract void normal();
    public abstract void alpha();
}

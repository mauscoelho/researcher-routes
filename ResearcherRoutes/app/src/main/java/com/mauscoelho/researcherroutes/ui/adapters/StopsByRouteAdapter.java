package com.mauscoelho.researcherroutes.ui.adapters;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mauscoelho.researcherroutes.R;
import com.mauscoelho.researcherroutes.network.models.StopsByRoute;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class StopsByRouteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<StopsByRoute> _stopsByRoute;

    public StopsByRouteAdapter(List<StopsByRoute> stopsByRoute) {
        this._stopsByRoute = stopsByRoute;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return _stopsByRoute.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        StopsByRoute stopsByRoute = _stopsByRoute.get(position);
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 0:
                bindMatchItem((RouteViewHolder) viewHolder, stopsByRoute);
                break;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_stops, viewGroup, false);
        return new RouteViewHolder(view);
    }


    private void bindMatchItem(RouteViewHolder viewHolder, final StopsByRoute stopsByRoute) {
        viewHolder.card_stops_name.setText(stopsByRoute.name);
    }


    public static class RouteViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.card_stops_name)
        TextView card_stops_name;

        public RouteViewHolder(View v) {
            super(v);
            ButterKnife.inject(this, v);
        }
    }
}


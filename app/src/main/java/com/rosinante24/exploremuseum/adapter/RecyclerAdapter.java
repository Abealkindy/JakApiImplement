package com.rosinante24.exploremuseum.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rosinante24.exploremuseum.activities.DetailActivity;
import com.rosinante24.exploremuseum.model.GambarList;
import com.rosinante24.exploremuseum.R;
import com.rosinante24.exploremuseum.response.MuseumResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rosinante24 on 21/11/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    private List<MuseumResponse.ResponseMuseumData> responseMuseumData;
    private List<GambarList> gambarLists;

    public RecyclerAdapter(Context context, List<MuseumResponse.ResponseMuseumData> responseMuseumData, List<GambarList> gambarLists) {
        this.context = context;
        this.gambarLists = gambarLists;
        this.responseMuseumData = responseMuseumData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_museum, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textnama.setText(responseMuseumData.get(position).getNama_museum());
        holder.textalamat.setText(responseMuseumData.get(position).getAlamat());
        holder.imageback.setImageResource(gambarLists.get(position).getGambar());
        holder.viewRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), DetailActivity.class);
                intent.putExtra("nama", responseMuseumData.get(position).getNama_museum());
                intent.putExtra("alamat", responseMuseumData.get(position).getAlamat());
                intent.putExtra("deskripsi", responseMuseumData.get(position).getDeskripsi());
                intent.putExtra("latitude", responseMuseumData.get(position).getLatitude());
                intent.putExtra("longitude", responseMuseumData.get(position).getLongitude());
                intent.putExtra("gambar", gambarLists.get(position).getGambar());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return responseMuseumData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageback)
        ImageView imageback;
        @BindView(R.id.textnama)
        TextView textnama;
        @BindView(R.id.textalamat)
        TextView textalamat;
        @BindView(R.id.viewRecycler)
        View viewRecycler;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

package com.rosinante24.exploremuseum.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.rosinante24.exploremuseum.model.GambarList;
import com.rosinante24.exploremuseum.R;
import com.rosinante24.exploremuseum.adapter.RecyclerAdapter;
import com.rosinante24.exploremuseum.network.ApiService;
import com.rosinante24.exploremuseum.network.RetrofitConfig;
import com.rosinante24.exploremuseum.response.MuseumResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<GambarList> gambarLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        addImageToList();
        ApiService api = RetrofitConfig.getInitRetrofit();
        Call<MuseumResponse> museumResponseCall = api.getMuseumData();
        museumResponseCall.enqueue(new Callback<MuseumResponse>() {
            @Override
            public void onResponse(Call<MuseumResponse> call, Response<MuseumResponse> response) {
                recycler.setAdapter(new RecyclerAdapter(getApplicationContext(), response.body().getData(), gambarLists));
                Log.d("Data : ", "" + response.body().getData());
            }

            @Override
            public void onFailure(Call<MuseumResponse> call, Throwable t) {
                Log.d("Data : ", "" + t.getMessage());
            }
        });
    }

    private void addImageToList() {
        //1
        GambarList gambarList = new GambarList(R.drawable.nationalmuseums);
        gambarLists.add(gambarList);
        //2
        gambarList = new GambarList(R.drawable.textilemuseums);
        gambarLists.add(gambarList);
        //3
        gambarList = new GambarList(R.drawable.tamanprasastis);
        gambarLists.add(gambarList);
        //4
        gambarList = new GambarList(R.drawable.jakartahistorymuseum);
        gambarLists.add(gambarList);
        //5
        gambarList = new GambarList(R.drawable.baharimuseums);
        gambarLists.add(gambarList);
        //6
        gambarList = new GambarList(R.drawable.menarasyahbandars);
        gambarLists.add(gambarList);
        //7
        gambarList = new GambarList(R.drawable.wayangmuseum);
        gambarLists.add(gambarList);
        //8
        gambarList = new GambarList(R.drawable.bankindonesiamuseum);
        gambarLists.add(gambarList);
        //9
        gambarList = new GambarList(R.drawable.mandirimuseum);
        gambarLists.add(gambarList);
        //10
        gambarList = new GambarList(R.drawable.artmuseumjakarta);
        gambarLists.add(gambarList);
        //11
        gambarList = new GambarList(R.drawable.vocshipyard);
        gambarLists.add(gambarList);
        //12
        gambarList = new GambarList(R.drawable.kotaintanbridge);
        gambarLists.add(gambarList);
        //13
        gambarList = new GambarList(R.drawable.proklamasis);
        gambarLists.add(gambarList);
        //14
        gambarList = new GambarList(R.drawable.joeang);
        gambarLists.add(gambarList);
        //15
        gambarList = new GambarList(R.drawable.stasiunjakartakota);
        gambarLists.add(gambarList);
        //16
        gambarList = new GambarList(R.drawable.gedungarsipnasionals);
        gambarLists.add(gambarList);
        //17
        gambarList = new GambarList(R.drawable.candranayas);
        gambarLists.add(gambarList);
        //18
        gambarList = new GambarList(R.drawable.sundakelapas);
        gambarLists.add(gambarList);
        //19
        gambarList = new GambarList(R.drawable.basoekiabdillah);
        gambarLists.add(gambarList);
    }
}

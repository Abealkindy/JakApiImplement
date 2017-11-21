package com.rosinante24.exploremuseum.activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rosinante24.exploremuseum.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    @BindView(R.id.imagebackdetail)
    ImageView imagebackdetail;
    @BindView(R.id.textdeskripsi)
    TextView textdeskripsi;
    @BindView(R.id.textnamadetail)
    TextView textnamadetail;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    private GoogleMap googleMaps;
    private String nama, alamat, deskripsi;
    private double latitude, longitude;
    private int gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        nama = getIntent().getStringExtra("nama");
        alamat = getIntent().getStringExtra("alamat");
        deskripsi = getIntent().getStringExtra("deskripsi");
        latitude = getIntent().getDoubleExtra("latitude", 0);
        longitude = getIntent().getDoubleExtra("longitude", 0);
        gambar = getIntent().getIntExtra("gambar", 0);

        imagebackdetail.setImageResource(gambar);
        textdeskripsi.setText(deskripsi);
        textnamadetail.setText(nama);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMaps = googleMap;

        LatLng sydney = new LatLng(latitude, longitude);
        googleMaps.addMarker(new MarkerOptions().position(sydney).title(alamat));
        googleMaps.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        googleMaps.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 16));
        googleMaps.getUiSettings().setAllGesturesEnabled(true);
        googleMaps.getUiSettings().setZoomGesturesEnabled(true);
    }
}

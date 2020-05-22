package com.captivators.touristapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class IndiaGate extends FragmentActivity implements
        OnMapReadyCallback,
        GoogleMap.OnPolylineClickListener,
        GoogleMap.OnPolygonClickListener{

    private GoogleMap mMap;
    private Button goToImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india_gate);
        goToImage = findViewById(R.id.xyzGate);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapGate);
        mapFragment.getMapAsync(this);

        goToImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndiaGate.this,ImageScan.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera


        LatLng indiaGate = new LatLng(28.612837, 77.229531);


        Marker tajmahal  = mMap.addMarker(new MarkerOptions().position(indiaGate).title("Taj Mahal").snippet("The Taj Mahal is an ivory-white marble mausoleum ").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("marker",150,150))));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(indiaGate));
        Polygon polyline1 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(28.619838, 77.218767),
                        new LatLng(28.625782, 77.232105),
                        new LatLng(28.609647, 77.249846),
                        new LatLng(28.595277, 77.253302),
                        new LatLng(28.592339, 77.232799),
                        new LatLng(28.601634, 77.229757),
                       // new LatLng(28.610610, 77.212204),
                        new LatLng(28.607264, 77.217970),
                        new LatLng(28.619838, 77.218767)));

        // Position the map's camera near Alice Springs in the center of Australia,
        // and set the zoom factor so most of Australia shows on the screen.
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(28.612837, 77.229531), 15));
        polyline1.setFillColor(0x1A388E3C);
        // Set listeners for click events.
        googleMap.setOnPolylineClickListener(this);
        googleMap.setOnPolygonClickListener(this);


    }

    public Bitmap resizeMapIcons(String iconName,int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }

    @Override
    public void onPolygonClick(Polygon polygon) {

    }

    @Override
    public void onPolylineClick(Polyline polyline) {

    }

}

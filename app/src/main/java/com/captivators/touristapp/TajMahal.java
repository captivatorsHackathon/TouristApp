package com.captivators.touristapp;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

public class TajMahal extends FragmentActivity implements
        OnMapReadyCallback,
        GoogleMap.OnPolylineClickListener,
        GoogleMap.OnPolygonClickListener{

    private GoogleMap mMap;
    private Button goToImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taj_mahal);
        goToImage = findViewById(R.id.xyz);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        goToImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TajMahal.this,ImageScan.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera

        LatLng tajMahal = new LatLng(27.175164, 78.042143);
        LatLng lotusTemple = new LatLng(28.553699, 77.258816);
        LatLng havaMahal = new LatLng(26.924175 ,75.826744);
        LatLng indiaGate = new LatLng(28.612837, 77.229531);


        Marker tajmahal  = mMap.addMarker(new MarkerOptions().position(tajMahal).title("Taj Mahal").snippet("The Taj Mahal is an ivory-white marble mausoleum ").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("marker",150,150))));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(tajMahal));
        Polygon polyline1 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(27.181340, 78.037618),
                        new LatLng(27.181501, 78.046059),
                        new LatLng(27.168777, 78.045968),
                        new LatLng(27.168938, 78.037691),
                        new LatLng(27.181340, 78.037618)));

        // Position the map's camera near Alice Springs in the center of Australia,
        // and set the zoom factor so most of Australia shows on the screen.
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(27.175164, 78.042143), 16));
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

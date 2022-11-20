package com.jaydeepsathwara.practical_10_20012011154

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jaydeepsathwara.practical_10_20012011154.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private val TAG = "MapActivity"
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private var lat = 23.0
    private var log = 72.21
    private var title = "Marker in Sydney"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val obj = intent.getSerializableExtra("Object") as Person
        Log.i(TAG, "onCreate: Object:$obj")
        lat = obj.Latitude
        log = obj.Longitude
        title = obj.Name
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(lat, log)
        //googleMap.uiSettings.isZoomGesturesEnabled = true;

        mMap.addMarker(MarkerOptions().position(sydney).title(title))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,8.0f))
    }
}
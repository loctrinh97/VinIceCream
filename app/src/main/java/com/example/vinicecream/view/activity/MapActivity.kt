package com.example.vinicecream.view.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.vinicecream.R
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_map.*

class MapActivity : AppCompatActivity() , OnMapReadyCallback{
    private var googleMap: GoogleMap?=null
    lateinit var mFusedLocationClient: FusedLocationProviderClient
    var latitudeA : Double = 0.0
    var longitudeA : Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getLastLocation()


                btnOK.setOnClickListener {
            var intentGPSToMe = Intent(this@MapActivity, HomeActivity::class.java)
            intentGPSToMe.putExtra("tabId", "me")
            startActivity(intentGPSToMe)
        }
    }

    private fun getLastLocation() {
        mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task ->
            var location: Location? = task.result
            if (location != null) {
//                Toast.makeText(
//                    this,
//                    "latitude : " + location.latitude.toString(),
//                    Toast.LENGTH_LONG
//                ).show()
                latitudeA = location.latitude
            }
            if (location != null) {
//                Toast.makeText(
//                    this,
//                    "longitude : " + location.longitude.toString(),
//                    Toast.LENGTH_LONG
//                ).show()
                longitudeA = location.longitude
            }
            val zoomLevel = 15.0f //This goes up to 21
            googleMap!!.addMarker(
                MarkerOptions().position(LatLng(location!!.latitude, location.longitude))
                    .title("You are here !!")
            )
            var latLng = LatLng(latitudeA,longitudeA)
            googleMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,zoomLevel))
        }
    }

    override fun onMapReady(p0: GoogleMap?) {
        googleMap = p0 ?: return
    }
}




//class MapActivity : AppCompatActivity(), OnMapReadyCallback {
//    private lateinit var googleMap: GoogleMap
//    val PERMISSION_ID = 42
//    lateinit var mFusedLocationClient: FusedLocationProviderClient
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_map)
//        val mapFragment = supportFragmentManager.findFragmentById(R.id.myMap) as SupportMapFragment?
//        mapFragment!!.getMapAsync(this)
//        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//        getLastLocation()
//
//
//        btnXacNhan.setOnClickListener {
//            var intentGPSToMe = Intent(this@MapActivity, HomeActivity::class.java)
//            intentGPSToMe.putExtra("tabId", "me")
//            startActivity(intentGPSToMe)
//        }
//    }
//
//
//    @SuppressLint("MissingPermission")
//    private fun getLastLocation() {
//        if (checkPermissions()) {
//            if (isLocationEnabled()) {
//
//                mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task ->
//                    var location: Location? = task.result
//                    if (location == null) {
//                        requestNewLocationData()
//                    } else {
//                        Toast.makeText(
//                            this,
//                            "latitude : " + location.latitude.toString(),
//                            Toast.LENGTH_LONG
//                        ).show()
//                        Toast.makeText(
//                            this,
//                            "longitude : " + location.longitude.toString(),
//                            Toast.LENGTH_LONG
//                        ).show()
//                        googleMap.addMarker(
//                            MarkerOptions().position(LatLng(location.latitude, location.longitude))
//                                .title("Current Location")
//                        )
//                    }
//                }
//            } else {
//                Toast.makeText(this, "Turn on location", Toast.LENGTH_LONG).show()
//                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
//                startActivity(intent)
//            }
//        } else {
//            requestPermissions()
//        }
//    }
//
//    @SuppressLint("MissingPermission")
//    private fun requestNewLocationData() {
//        var mLocationRequest = LocationRequest()
//        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//        mLocationRequest.interval = 0
//        mLocationRequest.fastestInterval = 0
//        mLocationRequest.numUpdates = 1
//
//        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//        mFusedLocationClient!!.requestLocationUpdates(
//            mLocationRequest, mLocationCallback,
//            Looper.myLooper()
//        )
//    }
//
//    var latidude: Double? = null
//    var longitude: Double? = null
//    private val mLocationCallback = object : LocationCallback() {
//        override fun onLocationResult(locationResult: LocationResult) {
//            var mLastLocation: Location = locationResult.lastLocation
//            latidude = mLastLocation.latitude
//            longitude = mLastLocation.longitude
//        }
//    }
//
//    private fun isLocationEnabled(): Boolean {
//        var locationManager: LocationManager =
//            getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
//            LocationManager.NETWORK_PROVIDER
//        )
//    }
//
//    private fun checkPermissions(): Boolean {
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) == PackageManager.PERMISSION_GRANTED &&
//            ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) == PackageManager.PERMISSION_GRANTED
//        ) {
//            return true
//        }
//        return false
//    }
//
//    private fun requestPermissions() {
//        ActivityCompat.requestPermissions(
//            this,
//            arrayOf(
//                Manifest.permission.ACCESS_COARSE_LOCATION,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ),
//            PERMISSION_ID
//        )
//    }
//
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String>,
//        grantResults: IntArray
//    ) {
//        if (requestCode == PERMISSION_ID) {
//            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
//                getLastLocation()
//            }
//        }
//    }
//
//    override fun onMapReady(p0: GoogleMap?) {
//        googleMap = p0?: return
//    }
//
//
//}

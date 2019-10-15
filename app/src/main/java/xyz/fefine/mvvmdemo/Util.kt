package xyz.fefine.mvvmdemo

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("bind:imageUrl")
fun loadImage(view: ImageView, url: String) {
    Log.d("hua", "img download $url")
    Glide.with(view).load(url).into(view)
}

fun checkPermission(activity: MainActivity) {
    if (ContextCompat.checkSelfPermission(activity,
            Manifest.permission.INTERNET)
        != PackageManager.PERMISSION_GRANTED) {

        // Permission is not granted
        // Should we show an explanation?
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                Manifest.permission.INTERNET)) {
            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.
        } else {
            // No explanation needed, we can request the permission.
            ActivityCompat.requestPermissions(activity,
                arrayOf(Manifest.permission.INTERNET),
                1)

            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
            // app-defined int constant. The callback method gets the
            // result of the request.
        }
    } else {
        // Permission has already been granted
    }
}
package xyz.fefine.mvvmdemo.viewmodel

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:ageBind")
fun ageBind(view: TextView, age: Int) {
    view.text = age.toString()
}
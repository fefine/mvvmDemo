package xyz.fefine.mvvmdemo.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShowViewModel: ViewModel(), View.OnClickListener {
    override fun onClick(p0: View?) {
        Log.d("hua", "click")
        this.currentName.value = "ming"
    }

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>("xiaohu")
    }



}
package xyz.fefine.mvvmdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShowViewModel: ViewModel() {

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>("xiaohu")
    }


}
package xyz.fefine.mvvmdemo.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.fragment_show.view.*
import xyz.fefine.mvvmdemo.R
import xyz.fefine.mvvmdemo.model.UserModel

class ShowViewModel: ViewModel(), View.OnClickListener {

    override fun onClick(p0: View?) {
        Log.d("hua", "click")
        when(p0?.id) {
            R.id.btn_update ->         this.currentName.value = "ming"
            R.id.btn_update_user -> this.currentUser.value = UserModel("ming", 17, "male")
            else  -> Log.d("hua", "invalid id")
        }
    }

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>("xiaohu")
    }

    val currentUser: MutableLiveData<UserModel> by lazy {
        val user = UserModel("xiaohu", 18, "male")
        MutableLiveData<UserModel>(user)
    }

}
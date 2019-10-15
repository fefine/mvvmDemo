package xyz.fefine.mvvmdemo.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class UserFragment: Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutInflater.inflate(R)
    }

}
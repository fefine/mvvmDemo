package xyz.fefine.mvvmdemo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import xyz.fefine.mvvmdemo.BR
import xyz.fefine.mvvmdemo.R
import xyz.fefine.mvvmdemo.model.User
import xyz.fefine.mvvmdemo.modelview.UserModelView

class UserFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.user_profile, container, false)
    }

    override fun onStart() {
        super.onStart()

        val user = User()

        /*
         val user = User()
        user.age = 20
        user.female = false
        user.firstName = "Johnny"
        user.lastName = "Depp"
        user.imageUrl = "https://sm.ms/image/HO5FUbKgPZdnoCl"
        user.tagline = "When Johnny Depp is young"

        /// Create the view model
        val userViewModel = UserModelView(user)

        /// Data-Binding
        val binding = DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_main)
        binding.setVariable(BR.user, userViewModel)
         */

        user.lastName = "lat"
        user.firstName = "ming"
        user.age = 20
        user.female = false
        user.imageUrl = "https://sm.ms/image/HO5FUbKgPZdnoCl"
        user.tagline = "first"

        val userModelView = UserModelView(user)

        val binding = DataBindingUtil.setContentView<ViewDataBinding>(this.requireActivity(), R.layout.user_profile)
        binding.setVariable(BR.user, userModelView)
    }

}
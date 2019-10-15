package xyz.fefine.mvvmdemo.modelview

import android.util.Log
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import xyz.fefine.mvvmdemo.BR
import xyz.fefine.mvvmdemo.model.User
import java.util.*

class UserModelView(private val user:User): Observer, BaseObservable() {

    init {
        user.addObserver(this)
    }

    override fun update(p0: Observable?, p1: Any?) {
        if (p1 is String) {
            Log.d("hua", "change $p1")
            if (p1 == "age") {
                notifyPropertyChanged(BR.name)
            } else if (p1 == "firstName" || p1 == "lastName") {
                notifyPropertyChanged(BR.name)
            } else if (p1 == "imageUrl") {
                notifyPropertyChanged(BR.imageUrl)
            } else if (p1 == "tagline") {
                notifyPropertyChanged(BR.tagline)
            } else if (p1 == "female") {
                notifyPropertyChanged(BR.gender)
            }
        }
    }

    val name: String
        @Bindable get() {
            return "${user.firstName} ${user.lastName}"
        }

    val age: String
        @Bindable get() {
            return user.age.toString()
        }

    val gender: String
        @Bindable get() {
            return if (user.female) return "Female" else "Male"
        }

    val imageUrl: String
        @Bindable get() {
            return user.imageUrl
        }

    val tagline: String
        @Bindable get() {
            return "Tagline: " + user.tagline
        }

    fun onButtonClick(view: View) {
        this.user.age = 35
        this.user.imageUrl = "https://sm.ms/image/PNEXwrV6LzSxd5p"
        this.user.tagline = "Now he has grown up..."
    }

}
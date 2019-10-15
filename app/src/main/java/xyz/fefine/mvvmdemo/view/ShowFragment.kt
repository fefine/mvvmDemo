package xyz.fefine.mvvmdemo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_show.*
import xyz.fefine.mvvmdemo.R
import xyz.fefine.mvvmdemo.viewmodel.ShowViewModel

class ShowFragment: Fragment() {

    private lateinit var model: ShowViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model = ViewModelProviders.of(this).get(ShowViewModel::class.java)

        val nameObserver = Observer<String> {
            newName -> txt_current_name.text = newName
        }

        // https://proandroiddev.com/5-common-mistakes-when-using-architecture-components-403e9899f4cb
        // don't use this
        model.currentName.observe(viewLifecycleOwner, nameObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show, container, false)
    }

    override fun onStart() {
        super.onStart()

        btn_update.setOnClickListener{ view -> model.currentName.value = "ming"}
    }

}
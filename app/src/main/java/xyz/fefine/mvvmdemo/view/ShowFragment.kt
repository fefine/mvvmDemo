package xyz.fefine.mvvmdemo.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_show.*
import xyz.fefine.mvvmdemo.BR
import xyz.fefine.mvvmdemo.R
import xyz.fefine.mvvmdemo.viewmodel.ShowViewModel

class ShowFragment: Fragment() {

    private lateinit var model: ShowViewModel
    private lateinit var binding: ViewDataBinding

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model = ViewModelProviders.of(this).get(ShowViewModel::class.java)

// --- start
//        val nameObserver = Observer<String> {
//            newName -> txt_current_name.text = newName
//        }

        // https://proandroiddev.com/5-common-mistakes-when-using-architecture-components-403e9899f4cb
        // don't use this
//        model.currentName.observe(viewLifecycleOwner, nameObserver)
// --- end

        // 必须使用
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.mv, model)

        Log.d("hua", "onActivityCreated")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_show, container, false)
        val view = binding.root
        Log.d("hua", "onCreateView")

        return view
    }

}
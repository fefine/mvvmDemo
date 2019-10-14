package xyz.fefine.mvvmdemo.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_counter.*
import xyz.fefine.mvvmdemo.ContractInterface
import xyz.fefine.mvvmdemo.R
import xyz.fefine.mvvmdemo.presenter.CounterPresenter

class CounterFragment: Fragment(), ContractInterface.View {

    private var presenter:ContractInterface.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onStart() {
        super.onStart()
        presenter = CounterPresenter(this)
        btn_add.setOnClickListener{presenter?.incrementValue()}
    }

    override fun initView() {
        Log.d("view", "init")
        tx_count.text = if (presenter != null) presenter?.getCounter() else "0"

    }

    override fun updateView() {
        tx_count.text = if (presenter != null) presenter?.getCounter() else "0"
    }
}
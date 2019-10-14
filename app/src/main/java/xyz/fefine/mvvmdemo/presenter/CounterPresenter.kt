package xyz.fefine.mvvmdemo.presenter

import android.util.Log
import xyz.fefine.mvvmdemo.ContractInterface
import xyz.fefine.mvvmdemo.model.CounterModel

class CounterPresenter(_view: ContractInterface.View): ContractInterface.Presenter {

    private val view = _view
    // todo 这里是否正确
    private val model = CounterModel()

    init {
        Log.d("counter", "init")
        view.initView()
    }

    override fun getCounter(): String {
        return model.getValue().toString()
    }

    override fun incrementValue() {
        model.incrementValue()
        view.updateView()
    }
}
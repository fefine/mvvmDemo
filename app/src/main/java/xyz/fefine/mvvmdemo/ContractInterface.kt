package xyz.fefine.mvvmdemo

interface ContractInterface {

    interface View {
        fun initView()
        fun updateView()
    }

    interface Model {
        fun getValue(): Int
        fun incrementValue()
    }

    interface Presenter {
        fun getCounter(): String
        fun incrementValue()
    }

}
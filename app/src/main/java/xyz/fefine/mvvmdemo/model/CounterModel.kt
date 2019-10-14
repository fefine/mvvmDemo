package xyz.fefine.mvvmdemo.model

import xyz.fefine.mvvmdemo.ContractInterface

data class Counter(var count: Int)

class CounterModel: ContractInterface.Model {
    private val counter = Counter(0)

    override fun getValue(): Int {
        return counter.count
    }

    override fun incrementValue() {
        counter.count += 1
    }
}
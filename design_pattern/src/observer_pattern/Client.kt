package observer_pattern

fun main(args: Array<String>) {
    var observer1 = ConcreteObserver1()
    var observable1 = ConcreteObservable1()
    observable1.subscribe(observer1)
    observable1.doEat()
    observable1.unSubscribe(observer1)

    second()
}


interface A {

}

open class Process {

}

//匿名内部类(Process类型)，同时实现A接口
var handle: Process = object : Process(), A {

}

fun first(callback: (String) -> String) {
    callback.invoke("first")
}

fun second() {
    println("in second before call first")
    println(first { param: String ->
        println("in second call callback $param")
        param
    })
    println("in second after call first")

}
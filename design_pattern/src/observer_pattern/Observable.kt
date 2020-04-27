package observer_pattern

//被观察者
interface Observable {
    fun subscribe(observer: Observer)
    fun unSubscribe(observer: Observer)
    fun notifyObserver(message: String)
}
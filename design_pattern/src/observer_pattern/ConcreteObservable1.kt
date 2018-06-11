package observer_pattern

class ConcreteObservable1 : Observable {

    var observerList: MutableList<Observer> = mutableListOf()

    override fun subscribe(observer: Observer) {
        observerList.add(observer)
        println("add a subscriber $observer")
    }

    override fun unSubscribe(observer: Observer) {
        observerList.remove(observer)
        println("remove a subscriber $observer")
    }

    override fun notifyObserver(message: String) {
        observerList.forEach({ observer -> observer.updateState(message) })
    }

    fun doEat() {
        var message = "observer1 do eat..."
        println("observable1 send: $message")
        notifyObserver(message)
    }
}
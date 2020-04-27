package observer_pattern

class ConcreteObserver1 : Observer {

    override fun updateState(message: String) {
        println("observer1 receive: $message")
    }
}
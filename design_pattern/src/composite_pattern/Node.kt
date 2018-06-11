package composite_pattern

abstract class Node {
    open lateinit var name: String

    open fun getInfo() {
        println("name:$name");
    }
}
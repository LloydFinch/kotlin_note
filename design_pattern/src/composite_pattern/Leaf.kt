package composite_pattern

class Leaf : Node() {

    override fun getInfo() {
        println("leaf:$name")
    }
}
package composite_pattern

class Root : Branch() {
    override fun getInfo() {
        println("root:$name")
    }
}
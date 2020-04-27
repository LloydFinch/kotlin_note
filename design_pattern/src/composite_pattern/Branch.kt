package composite_pattern

open class Branch : Node() {
    lateinit var children: MutableList<Branch>

    override fun getInfo() {
        println("branch:$name");
    }
}
/**
 * kotlin数据结构
 */

fun main() {

    testSet()

    testList()

    testMap()
}

fun testSet() {
    val set = emptySet<Int>()
    println(set)

    //list初始化，值为下标的倍
    val doubleList = List(10) { index -> index shl 1 }
    println(doubleList)

    println("===============================")
}

fun testList() {
    val list = emptyList<Int>()
    println(list)
    println("===============================")
}

fun testMap() {
    /**
     * 使用to来构造键值对，不限类型
     */
    val map = mapOf("hello" to 2, 2 to "hello")
    println(map)

    /**
     * 创建空map
     */
    val map2 = emptyMap<String, String>()
    println(map2)
    println("===============================")
}
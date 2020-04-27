/**
 * 扩展
 *
 * 1 扩展是静态解析的
 * 2 扩展并没有在一个类中插入新成员
 * 3 扩展函数与成员函数同时村砸爹情况下，优先取成员函数
 * 4 扩展函数的接收者可以声明为可空的
 * 5 扩展可以import进来使用
 */

fun main() {

    val list: MutableList<Int> = mutableListOf(1, 2, 3, 4)
    println(list)
    list.swap(1, 2)
    println(list)
    println(list.name)
    println(list.TAG)
}

/**
 * 扩展属性
 */
val List<Int>.name: String
    get() = "this is a list"


/**
 * 扩展函数
 * @receiver List<Int>
 */
fun MutableList<Int>.swap1(index1: Int, index2: Int) {
    this[index1] = this[index1] xor this[index2]
    this[index2] = this[index1] xor this[index2]
    this[index1] = this[index1] xor this[index2]
}


val Any.TAG: String
    get() = "$this extension"

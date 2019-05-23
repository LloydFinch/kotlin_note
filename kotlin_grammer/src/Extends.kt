/**
 * 函数的扩展
 *
 * 1 扩展是静态解析的(跟java的多态类似)
 * 2 扩展函数跟成员函数相同时会被成员函数覆盖
 * 3 扩展函数可以有可空接受者
 * 4 如果只有一个伴生对象，则伴生对象可以定义扩展函数与扩展属性
 * 5 扩展声明为成员，扩展接收者，分发接收者
 */

fun main() {

    val list: MutableList<Int> = mutableListOf(1, 2, 3)
    list.swap(0, 1)
    println(list)

    //使用扩展属性
    println(list.lastIndex)
}


fun MutableList<Int>.swap(index1: Int, index2: Int) {
    /**
     * 啊多么骚的代码
     */
    this[index1] = this[index2].also { this[index2] = this[index1] }
}

/**
 * 可空接收者的扩展函数
 * @receiver Any? 调用者
 * @return String 返回toString()值
 */
fun Any?.toString(): String {
    return this?.toString() ?: "null"
}

/**
 * 扩展属性，扩展属性不能有初始化器，只能get不能set
 */
val <T> List<T>.lastIndex: Int
    get() = size - 1
/**
 * 泛型
 * 泛型是在编译期执行，运行时会被擦除
 *
 * 基本同java类似
 *
 * out T: java的<? extends T>
 * in T: java的<? super T>
 *
 *
 *     PE - CS
 *
 *
 * 星投影
 *
 * 多个上界用where执行
 */


fun main() {

    val count: Count<Int> = Count(10)
//    println(count.t)

    count.test()
}

/**
 * 一般的泛型
 * @param T
 * @constructor
 */
class Count<T>(val t: T) {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val strs: Array<Any> = arrayOf("a", "b", "c")

    fun test() {

//        val arr: Array<Int> = arrayOf(1, 2, 3)
//        testOut(arr) //out使得可以传递Number的子类过去

        val arr2: Array<Number> = arrayOf(1, 2, 3)
        testIn(arr2) //in使得可以传递Int的父类过去
    }


    fun testOut(a: Array<out Number>) {
        val number: Int = 10
//        a[0] = number// 不能写，out做了限制
    }

    fun testIn(a: Array<in Int>) {
        val a = a[0]
    }


    fun <T : Number> test2(t: T) {

    }

    /**
     * 泛型的扩展函数
     */
    fun <T> T.tostring() {

    }

    /**
     * 如果需要多个上界，则使用where子句，尖括号只能放一个上界
     * 传进来的T必须同时满足所有的where子句
     */
    fun <T> testMoreLimit(list: List<T>) where T : Number, T : Comparable<T> {

    }
}


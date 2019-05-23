fun main() {

    /**
     * 函数最后一个参数是lambda，可以提取到括号外面
     */
//    fuck("hello") { 1 }

//    fuck2(0, 0)

//    testFunctionAPI()

//    testFunCombine(10) { number: Int -> { result: Int -> "result = ${number + result}" } }

    testS()
}


/**
 *
 * @param name String
 * @param action () -> Int
 */
fun fuck(name: String, action: () -> Int) {

}

/**
 * 默认参数
 * @param a Int
 * @param b Int
 */
fun fuck2(a: Int = 0, b: Int = 1) {

}

/**
 * 可变参数
 * @param str Array<out String>
 */
fun fuck3(vararg str: String) {

}

/**
 * 单表达式函数
 * @param number Int
 * @return Int
 */
fun inc(number: Int): Int = number + 1

/**
 * 中缀表达式 infix
 * 1 必须是成员函数或者扩展函数
 * 2 它们必须只有一个参数
 * 3 参数不能 his可变参数且不能有默认值
 * 在当前对象上调用infix函数时，必须显式使用this
 */
infix fun Int.inc(number: Int): Int = this + number

/**
 * 尾递归函数 tailrec
 *
 * 编译器会进行优化
 */
tailrec fun getFeibo(number: Int): Int {
    return if (number in 0..1) 1 else getFeibo(number)
}

/**
 * 一些很风骚的函数API
 */
fun testFunctionAPI() {
    val result = (0..10).fold(StringBuilder()) { acc, i ->
        acc.append("$i")
    }
    println("result = $result")

    /**
     * 做阶乘，依次乘以前一个数
     */
    val result2 = (1..5).fold(1, Int::times)
    println(result2)
}

/**
 * fold函数的原理
 * @receiver Collection<T>
 * @param initial R
 * @param combine (acc: R, nextElement: T) -> R
 * @return R
 */
fun <T, R> Collection<T>.fold2(initial: R, combine: (acc: R, nextElement: T) -> R): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}


/**
 * 挂起函数 suspend
 */

/**
 * 函数使用右箭头和圆括号结合
 * @param number Int
 * @param action (Int) -> ((Int) -> Unit)，这个参数是一个函数，这个函数接收一个参数返回一个函数
 */
fun testFunCombine(number: Int, action: (Int) -> ((Int) -> String)) {
    val result = action.invoke(number).invoke(100)
    println(result)
}

/**
 * 这牛逼的写法，实现一个接口，接口是表达式的写法，
 * 重载invoke函数，然后赋值为TODO()
 */
class InsTransformer : (Int) -> Int {
    override operator fun invoke(p1: Int): Int = TODO()
}

/**
 * 上述类型赋值给这个玩意，因为它们都是(Int)->Int类型的
 */
val intFunction: (Int) -> Int = InsTransformer()
val a = { i: Int -> i + 1 } //编译器自动推断a为(Int) -> Int
val a1: (Int) -> Int = { i: Int -> i + 1 } //这个是上面的原型

/**
 * 带和不带接收者的函数类型可以互换，接收者可以替代第一个参数
 * 可以视为这俩的类型是一样的
 */
val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
val repeatFun2: (String, Int) -> String = repeatFun //可以互相转换

fun testS() {
    println(a1.invoke(10))

    val str = "hello"
    val times = 2
    println(str.repeatFun(times)) //中缀调，可以视为扩展函数来调用
    println(repeatFun.invoke(str, times)) //也可以这么调

    println(repeatFun2.invoke(str, times)) //调另一个
    println(repeatFun2(str, times)) //也可以这么调 666


    /**
     * lambda表达式，
     * 将lambda传递给最后一个参数时，可以提到圆括号外面，
     * 如果lambda是唯一的参数，那么这个参数可以省略
     */
    val sum = { x: Int, y: Int -> x + y }
    println(sum(10, 10))

    /**
     * 匿名函数
     */
    val funAny = fun(x: Int, y: Int): Int = x + y
    println(funAny(10, 10))

    /**
     * 闭包
     */
    val sum2 = fun Int.(other: Int): Int = this + other
    println(sum2(10, 10))

}

/**
 * 内敛函数
 */
inline fun fuck2() {
    println("this is a inline function")
}



























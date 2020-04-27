import kotlin.random.Random

fun main() {
//    forT()
//    switchTwoVarible()
    actionScopeT()
}

//起别名
typealias  fu1 = Map<String, String>

fun foldT() {
    /**
     * 迭代运算
     */
    val fold = (0..10).fold(StringBuilder()) { acc, i ->
        acc.append(i)
    }
    println(fold)
}

fun funToClass() {
    fun sum(): Unit = foldT()

    fun number() = 10

    fun switch(numner: Int) = when (numner) {
        1 -> {
        }
        else -> {
        }
    }
}

fun forT() {
    val list = listOf(0 until 9).flatten()
    for (index in list.indices) {
        print("index=$index,value=${list[index]}")
    }
}

fun lazyT() {
    val t: String by lazy {
        "lazy"
    }
}

/**
 * 三目运算符类似
 */
fun notNullElse() {
    val str: String? = ""
    println(str?.length) //不为null就打印length
    println(str ?: "null") //为null就打印null
    println(str?.length ?: "null") //不为null就打印length，否则就打印null

    val length1 = str?.run { length } ?: 0
}

fun tryCatch() {
    val count: String = try {
        "hello"
    } catch (e: Exception) {
        "error"
    }
}

fun switchTwoVarible() {
    var a = 1
    var b = 2
    println("a=$a, b=$b")
    //因为also返回对象本身
    b = a.also { a = b }
    println("a=$a, b=$b")
}

fun typeAlias() {
    fun fun1() = { a: Int, b: Int -> a + b }
}

fun stringT() {
    val hello = "hello"
    hello.trimIndent()
    hello.trimMargin()
}

/**
 * 作用域函数 apply/with/run/also/let
 */
fun actionScopeT() {
    //run, apply, (with)内部的上下文this直接就是参数
    //let, also内部的上下文this是所处的外部环境，it才是参数

    //apply, also返回上下文对象
    //let, run, (with)返回最后一行

    /**
     * apply this,对象
     * run this,最后一行
     * also it,对象
     * let it,最后一行
     * with this,最后一行,跟run一样，只是调法不同
     * run和with都不是扩展函数，可以没有调用者，作为表达式给变量赋值
     */

    val str = "hello"
    val count = str.apply {
        "hello"
        "world"
    }
    println(count)

    val count1 = str.let {
        "hello"
        "world"
    }
    println(count1)

    str.also {

    }

    str.run {

    }

    //with是这么用的，跟when调用方式一样
    with(str) {

    }

    val numbers = mutableListOf("a", "bc")
    numbers.map { it.length }.filter { it > 0 }.let(::println)


    //takeIf/takeUnless，带有条件的域函数
    val number = Random.nextInt(100)
    val evenOrNull = number.takeIf { number % 2 == 0 }
    val oddOrNull = number.takeUnless { number % 2 == 0 }
    println("even:$evenOrNull, odd:$oddOrNull")

    //run不是扩展函数，可以作为表达式用
    val temp = run {
        "hello, android"
    }
    println(temp)
}

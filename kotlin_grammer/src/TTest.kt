fun main() {
//    println(add3().invoke(1, 2))

//    val a = add4(1, add3())
//    println(a)
//
//    add5("hello")
//    add5("hello", "android")

//    shlshr()

//    add7()

    val a = 1 shl 2 + 2


    val b = 1.shl(2 + 2)
    println(a)
}


fun hello(): String {
    return ""
}

/**
 * 函数的默认参数
 * @param a Int
 * @param b Int
 * @return Int
 */
fun add2(a: Int = 1, b: Int): Int {
    return a + b
}

/**
 * 函数表达式
 * @return (Int, Int) -> Int
 */
fun add3(): (Int, Int) -> Int = { a, b ->
    a + b
}

fun add6(a: Int) = a + 1

val funAny = fun(x: Int, y: Int): Int = x + y


/**
 * 函数参数
 * @param a Int
 * @param add Function2<Int, Int, Int>
 * @return Int
 */
fun add4(a: Int, add: (Int, Int) -> Int): Int {
    return add.invoke(a, 1)
}

/**
 * 可变参数
 * @param str Array<out String>
 */
fun add5(vararg str: String) {

}

fun shlshr() {
    var a = 10
    var b = a shl 1

    println(b)

    val b1 = a inc 1
    println(b1)
}

fun add7() {
    val result = (0..10).fold(StringBuilder()) { acc, i ->
        acc.append("$i")
    }
    println(result)

//    (0..9).forEach {
//        println(it)
//    }


    val result2 = combine(10, { str, b ->
        str + b.toString()
    })

    println(result2)
}


fun combine(number: Int, action: (str: String, b: Int) -> String): String {
    var result: String = ""
    //[0..10]
    for (i in 0..number) {
        result = action.invoke(result, i)
    }

    return result
}


fun testScope() {
    val a = 10
    a.apply {
        var b = this + 1
    }

    a.also {

    }

    a.let {

    }


    with(a) {

    }

}

fun swap2() {
    var a = 10
    var b = 20

//    a = b.also { b = a
    a = realalso(b, { value ->
        b = a
    })
}

fun realalso(real: Int, block: (Int) -> Unit): Int {
//    block(real)

    return real
}


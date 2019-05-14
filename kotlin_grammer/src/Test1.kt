fun main() {
//    forT()
    switchTwoVarible()
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
package mooc_demo.face_object

import java.lang.StringBuilder

fun main(args: Array<String>) {

    //函数作为参数
    args.forEach { println(it) }
    args.filter { it.isNotEmpty() }

    //将函数视为变量赋值给局部变量
    val hello = Hello()
    val function = hello::hello
    function.invoke() //执行function，不需要参数，因为已经指向hello这个实例了

    //对比上面的写法
    val function2 = Hello::hello
    function2.invoke(Hello()) //执行function，需要一个实例对象，因为没有指向任何Hello实例


    //一些内置的风骚API

    //1 将集合的元素进行转换
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    val newList = ArrayList<Int>()
    list.forEach {
        val newElement = it * 2
        newList.add(newElement)
    }
    newList.forEach { println(it) }

    //使用list.map进行转换
    val newList2 = list.map {
        //        it * 2
        it.toDouble()
    }
    newList2.forEach { println(it) }

    //2 将集合的元素展开
    val list2 = listOf(1..20, 2..5, 100..200)
    val flatList = list2.flatMap { intRange ->
        intRange //这里直接返回
//        intRange.map {
//            "No $it"
//        } //这里再次进行转换
    }
    flatList.forEach { println(it) }


    //3 迭代运算
    val result = flatList.reduce { acc, i -> acc + i }
    println(result)

    //自定义函数实现
    val number = factorial(10)
    println(number)
    //再风骚一点，先使用自定义函数转换再打印
    (0..10).map { factorial(it) }.forEach { println(it) }
    //更风骚一点，上面的转换后再累加一下
//    val number2 = (0..10).map { factorial(it) }.reduce { acc, i -> acc + i }
    //这个跟上面一样，只是赋了一个初始值5
//    val number2 = (0..10).map { factorial(it) }.fold(5) { acc, i ->
//        acc + i
//    }
    //这个把初始值设为StringBuilder，那么后续操作就是针对字符串的了
    val number2 = (0..10).map { factorial(it) }.fold(StringBuilder()) { acc, i ->
        acc.append(i)
    }
    println(number2)

    //集合添加隔离符
    println((0..6).joinToString("|"))
}

//使用list.reduce函数实现累乘
fun factorial(n: Int): Int {
    if (n == 0) {
        return 1
    }
    return (1..n).reduce { acc, i -> acc * i }
}

class Hello {

    fun hello() {
        println("hello world")
    }
}

/**
 * 总结一下
 */
fun summary() {
    var list = listOf(1, 2, 3, 4, 5)
    var list1 = listOf(1..4, 10..13)

    list.map { it + 1 }
    list1.flatMap { it }
    list.reduce { acc, i ->
        acc + i
    }
    list.joinToString { "|" }
    (0..10).fold(StringBuilder()) { acc, i ->
        acc.append(i)
    }
}
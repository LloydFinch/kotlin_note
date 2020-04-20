fun main() {

    testDeconstruction()
}

/**
 * 解构声明
 * 原理就是component()函数
 */
fun testDeconstruction() {

    data class User(var name: String, var age: Int)
    val (name, age) = User("zhaoyun", 24) //需要有个componentX属性
    println("name = $name, age = $age")
    println()

    /**
     * 甚至这么用
     */
    fun getUser(): User {
        return User("null", 0)
    }
    val (name1, age1) = getUser()
    println("name1 = $name1, age1 = $age1")
    println()

    //'_'用于未使用的变量(1.1起)
    val (_, age2) = getUser()
    println("age2 = $age2")
    println()

    val map: MutableMap<String, String> = HashMap()
    map["hello"] = "world"
    map["android"] = "kotlin"
    for ((k, v) in map) { //解构声明遍历集合
        println("key = $k, value = $v")
    }
    println()

    //lambda中的解构(1.1起)
    map.mapValues { (key, value) -> println("key = $key, value = $value") }
    println()
}

/**
 * 使用Nothing来表述一个永远不会返回的函数
 */
fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

/**
 * 构造函数私有的简明类写法
 */
private class No private constructor()

/**
 * kotlin定义注解跟java类似
 */
annotation class Suspendable

/**
 * kotlin的注解可以用于lambda表达式
 */
val f = @Suspendable {}



































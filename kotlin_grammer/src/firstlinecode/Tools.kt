package firstlinecode

import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException

/**
 *
 * Name: Tools
 * Author: lloydfinch
 * Function: Tools
 * Date: 2020-04-21 18:34
 * Modify: lloydfinch 2020-04-21 18:34
 */

fun main() {
//    testClass()

    testStringExtention()
}

fun doAction3() {
    println("doAction3()")
}

fun doAction() {
    println("doAction")
}

fun doAction2(): Unit {
    println("doAction2")
}

fun testClass() {
    val classJava = String::class.java
    println(classJava)
    val clasz = String::class
    println(clasz)
    val javaClass = String::javaClass
    println(javaClass)
}


private lateinit var hello: String

fun testInitialized() {

    try {
        //检测是否没有初始化
        if (!::hello.isInitialized) {
            throw UninitializedPropertyAccessException("not init hello property")
        }

    } catch (e: UninitializedMessageException) {
        println("未初始化异常")
    }
}

fun testStringExtention() {
    val str = "helloids$%@#$@#%@123123!@#$%ASDFEREW489324934EREl"
    println(str.letterCount())
}
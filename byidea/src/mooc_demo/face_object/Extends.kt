package mooc_demo.face_object

import java.lang.StringBuilder

/**
 * 扩展函数
 * 运算符重载
 */
fun main(args: Array<String>) {
    val string = "abc"
    //这个是扩展了函数
    println(string.mutiply(10))
    //这个是扩展了运算符
    println(string * 10)
}

/**
 * 扩展函数:将字符串累加number次(名字自定义)
 */
fun String.mutiply(number: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until number) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}

/**
 * 实现上述一样的功能，不过是运算符的重载，使得String可以进行乘算
 */
operator fun String.times(number: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until number) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}
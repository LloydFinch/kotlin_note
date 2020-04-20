/**
 * 可空类型会被自动装箱的，所以进行===运算需要注意
 */


/**
 * char 16
 * byte 8
 * boolean 1
 * short 16
 * int 32 4byte
 * long 64
 * float 32
 * double 64
 */

fun main() {
//    testInt()
    testChar()

    val a :Int = 10


}


fun testInt() {
    val a: Int = 1000
    val a1: Int = a
    val a2: Int = a
    println(a1 == a2)
    println(a1 === a2) //true

    //可控类型有装箱操作
    val a3: Int? = a
    val a4: Int? = a
    println(a3 == a4) //true
    println(a3 === a4) //false


    /**
     * Int和Long不具备任何继承关系，完全独立的两个类
     * 所以不能相互赋值也不能进行值比较
     * 类型隐式转换: 小类型+大类型=大类型
     */
    var num1: Int = 10
    var num2: Long = 20
    val sum = num1 + num2
    println(sum.javaClass.typeName) //long


    println(a.toLong())
}


fun testChar() {
    /**
     * Char不能当作数字使用
     * Char+Int=Char
     */
    val c = '1'
    if (c !in '0'..'9') {
        println("out of range!")
    }

    val temp = 9
    val d: Char = c + temp
    println(d)
}

fun testArray() {
    /**
     * 类型不型变(不能多态使用)
     */
    var arrInt: Array<Int> = arrayOf(123)
//    var arrNumber: Array<Number> = arrInt //报错，java是可以的
}

fun uType() {
    /**
     * kotlin从1.3开始引入了无符号类型和无符号数组
     */
}

fun whenT() {
    val result = when (val char = "hello"[0]) {
        'a' -> println(char)
        else -> {
            println("is not a")
        }
    }
}

fun forFor() {
    val arrayInt = arrayOf(1, 22)
    arrayInt.withIndex()
    arrayInt.indices
}

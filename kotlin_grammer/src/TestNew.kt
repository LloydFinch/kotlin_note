import java.lang.Exception
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

fun main() {


//    strTraversal()
//    forTraversal()
//    testReturn()
//    testPreoperty()


    var a = 10
    var b = 20
    println("a=$a,b=$b")
//    b = a.also { a = b }
    b = a.apply { a = b }
    println("a=$a,b=$b")
}


/**
 * 字符串遍历
 */
fun strTraversal() {
    val str = "hello"

    for (s in str) {
        println(s)
    }
}

/**
 * for循环遍历
 */
fun forTraversal() {
    val arr = intArrayOf(1, 2, 3, 4, 5)
    for (i in arr) {
    }

    for (i in 1..4) {

    }

    for (i in 1 until 4) {

    }

    for (i in 1 downTo 4) {

    }

    //这里要注意倒序
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
}

/**
 * 跳转语句
 */
fun testReturn() {

    fun foo() {
        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                // 从传入 run 的 lambda 表达式非局部返回
                if (it == 3) return@loop
                print(it)
            }
        }
        print(" done with nested loop")
    }
    foo()
}

/**
 * 对象
 */
fun testSingleInstance() {

    //单例
    FuckSingleInstance.showSelf()

    //object表达式=new匿名内部类
    val ob: InterfaceI = object : Runnable, InterfaceI {
        override fun run() {

        }

        override fun tt() {

        }
    }

    val ob2: InterfaceI = ob
}

interface InterfaceI {
    fun tt()
}

/**
 * 属性
 */
fun testPreoperty() {
    val kt = KT();
    kt.name = "kt"
    println("kt.name=${kt.name}")
}

/**
 * 属性以一定要使用field，防止StackOverFlow
 * @property name String?
 */
class KT {

    var name: String? = ""
        get() = "$field.kt"
        set(value) {
            field = value
            println(value)
        }
}

/**
 * 这一条继承逻辑跟java类似，只是需要几个关键字
 * kotlin默认是public final的，java默认是open的
 */
open class Super1 {
    protected open var name: String = ""

    open fun getInSuper() {
        println("get in super")

        val childInner: Child1.ChildInner
    }
}

/**
 * 重载方法，可以通过super来访问基类的成员
 */
class Child1 : Super1() {
    public override var name: String = ""

    override fun getInSuper() {
        println("get in child")
    }

    fun getInChild() {
        println("get in child outer")
    }

    fun test() {
        super.getInSuper()
    }

    inner class ChildInner {
        fun getInChild() {
            println("get in child inner")
        }

        fun test() {

        }
    }
}


open class I1 {
    open fun func1() {

    }
}

interface I2 {
    fun func1() {

    }
}

class O1() : I1(), I2 {

    override fun func1() {
        /**
         * 多个基类函数需要指明调的谁的
         */
        super<I1>.func1()
        super<I2>.func1()
    }
}

/**
 * 抽象类
 * abstract的一定是open的
 * open的不一定是abstract的
 */
abstract class AbstractC {
    abstract fun test()
}

/**
 * 指定构造函数的可见性，必须显式使用constructor关键字
 * 构造器只有public和private两种类型
 */
class C2 private constructor() {

    fun t() {
        val a: String = "hello"
    }
}


fun test2() {
//    val c2 = C2()
}

fun highFunc(a: Int, action: (Int, Int) -> Int) {
    action(a, a + 1)
}


fun swap() {
    var a = 1
    var b = 2

    val str = "hello"
    println(str)
}







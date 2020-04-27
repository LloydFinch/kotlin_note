/**
 * 1 初始化块会成为主构造的一部分
 * 2 委托主构造的调用会成为次构造的第一条语句
 */

fun main() {

//    InitOrder("hello", 20)
//    println()

    /**
     * 如果主构造函数都有默认值，JVM会自动生成一个无参构造函数，
     * 这个构造函数使用默认值
     */
    InitOrder()
    println()
//
//    Child("name")
//    println()
//
//    compareDataClass()
//    println()
}

/**
 * 编译期常量
 */
const val HELLO_ANDROID = "HELLO_ANDROID"


/**
 * 初始化顺序
 * 初始化块会跟属性初始化一起执行，按照顺序执行
 * 初始化块是主构造函数的一部分
 */
class InitOrder(name: String = "null") {

    val first = "first property $name".also(::println)

    init {
        println("init1 $name")
    }

    val second = "second property $name".also(::println)

    init {
        println("init2 $name")
    }

    constructor(name: String, age: Int) : this(name) {
        println("second constructor $name, $age")
    }

    //等价于Java的静态代码
    companion object {
        init {
            println("first init in companion")
        }

        val sFirst = "first property in companion".also(::println)

        init {
            println("second init in companion $sFirst")
        }
    }


}

open class Super {
    constructor() {
        println("super constructor")
    }

    open fun hello() {

    }

    open fun hello(str: String) {

    }
}

open class Child : Super {
    constructor(name: String) {
        println("child constructor $name")
    }


    override fun hello() {

    }

    /**
     * 拦截继承关系
     */
    final override fun hello(str: String) {

    }
}

class Sun : Child {

    /**
     * 属性覆盖var可以覆盖val，但是val不能覆盖var
     *
     * 基类的所有初始化(值初始化和init)发生在派生类之前，
     * 所以应该避免在基类的初始化代码中调用open函数
     */


    /**
     * TODO 幕后字段略过
     */


    /**
     * 编译期常量，使用const可以标记为编译期常量，
     * 编译期常量必须是String或者基本数据类型
     */


    /**
     * 属性初始化器
     */
    var str: String = "hello"
        private set
    /**
     * 延迟初始化属性和变量
     */
    lateinit var temp: String

    constructor() : super("Sun") {
        temp = "hello"
        println("sun constructor")
    }

    /**
     * 不能继承了，覆盖会报错
     */
//    override fun hello(str: String) {
//        super.hello(str)
//    }

    override fun hello() {
    }

    fun test() {
        hello() //调用自己的hello
        super.hello() //调用父类的hello
    }

    fun t2() {
        str = "hello"
    }

    fun isInit() {
        //检查是否已经初始化
        if (this::temp.isInitialized) {
            println("has initialized")
        } else {
            println("has not initialized")
        }
    }

    inner class T {
        //内部类中使用外部类的基类的方法super@Outter.func()
        //属性访问方式相同
        fun test() {
            hello()
            super@Sun.hello()
        }
    }
}

interface A {
    fun t1() //没有方法体就是抽象的
    fun t2() {} //有方法体是非抽象的
}

class B : A {
    /**
     * 抽象的t1必须实现，非抽象的t2可以不实现
     */
    override fun t1() {

    }
}

/**
 * 数据类至少有一个构造参数，并且所有构造参数要声明为为val或var，
 * 数据类不能是抽象、开放、密封或者内部的
 *
 * 但是通过一些插件可以声明不带构造参数的数据类
 *
 * 数据类默认附带equals(),hashCode(),toString(),componentN(),copy()函数，
 * 生成这些默认函数仅仅使用主构造函数内部定义的属性
 *
 * 数据类的component函数使得它们可以解构声明中使用
 */
data class User(var id: String) {
    var name: String = "null"

    /**
     * copy函数的原型
     */
//    fun copy(id: String) = User(id)
}

/**
 * 测试数据类的比较
 */
fun compareDataClass() {
    val user1 = User("100")
    val user2 = User("100")
    user1.name = "hello"
    user2.name = "world"
    println(user1 == user2) //true，只比较在主构造内的参数id，name不参与比较
    println(user1 === user2) //false，比较地址
    println("user1=$user1") //toString()也只针对主构造的参数，name不会被打印

    /**
     * copy也只针对主构造内的构造参数，所以name不会别copy
     */
    val userCopy = user1.copy()
    val userCopy2 = user2.copy(id = "101")
    println("user1=$userCopy, user2=$userCopy2")
}

/**
 * 密封类:适用于有限的枚举，多用于when表达式
 *
 */
sealed class Exp {

}

class A1 : Exp()
class B1 : Exp()
class C1 : Exp()

fun test(exp: Exp) = when (exp) {
    is A1 -> {
    }
    is B1 -> {
    }
    is C1 -> {

    }
    else -> {

    } //else可以省略，因为已经使用密封类覆盖所有条件了
}

/**
 * 内部类
 */
class Outter {

    /**
     * 这个默认是static的
     */
    class InnerStatic {

    }

    /**
     * 使用inner标记为非static的
     */
    inner class Inner {

    }
}

@FunctionalInterface
interface Action {
    fun action()
}

fun testClass2() {
    //静态内部类
    val inner1 = Outter.InnerStatic()
    //非静态内部类
    val inner2 = Outter().Inner()

    //单函数接口，直接用lambda创建
    val runnable = Runnable {

    }
    //自己写的不行?
    val action = object : Action {
        override fun action() {

        }
    }
}

/**
 * 枚举类可以实现接口，但是不能继承
 */
enum class Enum1 : Action {
    E1 {
        override fun action() {
            println("E1 action")
        }
    },

    E2 {
        override fun action() {
            println("E2 action")
        }
    };
}


/**
 *
 * public int add(int a, int b){
 *         return a+b
 * }
 *
 *
 *
 *
 */

fun add(a: Int, b: Int): Int {
    return a + b
}

fun add1(a: Int, b: Int): Int = a + b

fun add(): (Int, Int) -> Int = { a, b ->
    a + b
}







































































































/**
 * 对象
 */
fun main() {
    test1()
}

/**
 * 匿名对象只能用于本地或私有作用域中返回，如果用在公有函数的返回类型或公有属性的类型，
 * 则会返回超类型，如果没有超类型就返回Any，此时匿名对象中的成员将无法访问
 */
fun test1() {
    /**
     * 仅仅创建一个简单的对象，不需要声明类
     */
    val aObj = object : Super() {
        var x: Int = 0
        var y: Int = 0

        override fun toString(): String {
            return "[$x,$y]"
        }
    }

    println(aObj)

    println("${aObj.x},${aObj.y}")
}

open class C {

    var count = 100

    private fun t1() = object {
        val x = 10
        /**
         * 匿名内部类可以使用外部的变量，
         * 即使它不是final的
         */
        fun add() {
            count++
        }

        fun sub() {
            count--
        }
    }

    fun t2() = object {
        val x = 10;
    }

    fun test() {
        println(t1().x) //可以取到
//        println(t2().x) //取不到，因为认为t2是Any
    }
}

/**
 * 线程安全的单例
 * 单例可以实现接口或继承父类
 */
object Single : Action {
    override fun action() {
        println("action in single instance")
    }

    fun show() {
        println("this is a single instance")
    }
}

/**
 * 伴生对象
 *
 * 看起来想java的静态成员，但是运行时是真实对象的实例成员
 * 可以使用@JvmStatic标注为真正的静态方法或字段
 *
 * 可以继承类和实现接口
 *
 *
 * 初始化相关
 * 对象表达式是在使用的使用立即执行及初始化的
 * 对象声明是在第一次被访问的到时延迟初始化的
 * 伴生对象是在相应的类加载时初始化的，跟java静态初始化相同
 */
class Comp {
    companion object : C(), Action {
        @JvmStatic
        val sHello = "hello for static" //静态成员

        val hello = "hello"

        @JvmStatic
        fun sHello() {
            println("hello")
        } //静态方法

        fun hello() {
            println("hello ")
        }


        override fun action() {
            println("action in company object")
        }
    }
}

/**
 * 设置类型别名
 */
fun testAlias() {
    val ln: LN //使用别名

    fun fuck() {
        
    }
}

typealias LN = List<Number>
typealias handle = (Int, Int) -> Int
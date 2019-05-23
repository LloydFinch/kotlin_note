import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * 委托 by
 */
fun main() {
//    test()
//    testProperty()
    testObservable()
}


interface Base {
    val number: Int
    fun print()
    fun fuck()
}

class BaseImpl(val x: Int) : Base {
    override val number: Int
        get() = 10

    override fun print() {
        print("x = $x")
    }

    override fun fuck() {
        println("fuck in BaseImpl $number")
    }
}

class Derived(b: Base) : Base by b //by b表示b将会在Derived内部存储，并且会自动将Base的所有方法转发给b
{
    //委托中使用的是自己的number，而不是这个
    override val number: Int
        get() = 100

    /**
     * 覆盖委托中的方法，会优先调用这个
     */
    override fun fuck() {
        println("fuck in Derived: $number")
    }
}

fun test() {
    val b = BaseImpl(10)
    val derived = Derived(b)
    derived.print()
    derived.fuck()
}

/**
 * 属性委托
 */

fun testProperty() {
    var p: String by Delegate()
    p = "hello"
    println(p)

    println(lazyValue)
    println(lazyValue)
}

/**
 * 属性委托的模版
 */
class Delegate {
    /**
     * 访问属性时调用
     * @param target Any?
     * @param property KProperty<*>
     * @return String
     */
    operator fun getValue(target: Any?, property: KProperty<*>): String {
        println("some want get value by delegate")
        return "fuck"
    }

    /**
     * 设置属性时调用
     * @param target Any?
     * @param property KProperty<*>
     * @param value String
     */
    operator fun setValue(target: Any?, property: KProperty<*>, value: String) {
        println("some want set value by delegate")
    }
}

/**
 * lazy是synchronized的，可以传递参数来改变
 * {@link LazyThreadSafetyMode}，这个可以记一下
 */
val lazyValue: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
    println("lazy body") //仅第一次执行，后续只会执行返回值
    "lazy"
}

/**
 * 可观察属性
 */
fun testObservable() {
    var name: String by Delegates.observable("null", { property, oldValue, newValue ->
        println("property $property: $oldValue -> $newValue")
    })

    name = "hello"
    name = "world"

    /**
     * 可以拦截的
     */
    var sex: String by Delegates.vetoable("null", { property, oldValue, newValue ->
        println("property $property: $oldValue -> $newValue")
        "hello" == newValue
    })

    sex = "hello"
    sex = "world"
}






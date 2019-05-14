package mooc_demo.face_object

import kotlin.reflect.KProperty

/**
 * 代理
 */
class Delegate {
    val hello by X() //代理只能get
    var hello2 by X() //可以get和set
}

/**
 * 代理
 */
class X {

    private var value: String? = null
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("get $thisRef -> $property")
        return value ?: "null"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("set $thisRef -> $property -> $value")
        this.value = value
    }
}

fun main(args: Array<String>) {
    val delegate = Delegate()
    println(delegate.hello)
    println(delegate.hello2)

    delegate.hello2 = "set value for hello2"
    println(delegate.hello2)
}
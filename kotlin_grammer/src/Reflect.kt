import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.declaredMemberProperties

/**
 * 反射(统一使用java的API来搞 ::class.java)
 * 跳过
 */
fun main() {
    val my = My()
    val myClass2: Class<My> = my.javaClass
    val myClass = My::class
    myClass.declaredMemberProperties.forEach {
        println(it)
    }

    myClass.declaredFunctions.forEach {
        println(it)
    }

    /**
     * 跟java类似的用.java来玩
     */
    val method = myClass.java.getMethod("say")
    method(my)

    println(myClass.javaObjectType)

    println("=======================================================")
    myClass2.methods.forEach {
        println(
            "${it.name}, ${it.parameterCount}, ${if (it.parameterCount > 0) {
                it.parameterTypes[0]
            } else {
                ""
            }}"
        )
    }
    println("=======================================================")

    /**
     * 应该这么写,参数写为String::class.java，而不是String.javaClass
     */
    myClass2.getMethod("say2", String::class.java).invoke(my, "hello")
    println("=======================================================")

    //还能这么调
    println(myClass2.kotlin)
}

class My {
    val name: String = "name"
    fun say() {
        println("called say function")
    }

    fun say2(msg: String) {
        println("called say2 $msg")
    }
}
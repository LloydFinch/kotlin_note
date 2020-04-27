/**
 * 判断属性的一些修饰符
 * 可以用来检测坑爹的lateinit(1.2)
 */
class KTObj {

    lateinit var name: String

    fun judge() {
        if (this::name.isInitialized) {
            println("name, has been init")
        } else {
            println("error, name has not init")
        }
    }
}

fun main() {
    val kt = KTObj()
    kt.name = "kotlin"
    kt.judge()

    try {
        kt.name.toString()
    } catch (e: UninitializedPropertyAccessException) {
        println(e.message)
    }


    kt.let {

    }

    kt.also {

    }

    kt.apply {

    }
    with(kt) {

    }
    kt.run {

    }
}
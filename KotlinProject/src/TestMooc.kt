import java.util.*

/**
 * String test
 */
fun testMString() {
    var str1 = "hello kotlin!"
    var str2 = String(charArrayOf('h', 'e', 'l', 'l', 'o'))

    println("str1=$str1,str2=$str2");
}

/**
 * set and get test
 */
class TestMooc {
    lateinit var b: String;
    val c by lazy { }
    var a: String = ""
        get() {
            return field + 1
        }
        set(value) {
            field = (value + 1)
        }
}

/**
 * operator test
 */
class Complex(var real: Double, var imaginary: Double) {

    /**
     * real plus imaginary
     */
    operator fun plus(other: Complex): Complex {
        return Complex(real + other.real, imaginary + other.imaginary)
    }

    /**
     * only real plus
     */
    operator fun plus(other: Int): Complex {
        return Complex(real + other, imaginary)
    }

    /**
     * args override
     */
    operator fun plus(other: Any): Int {
        return real.toInt()
    }

    override fun toString(): String {
        return "$real + ${imaginary}i"
    }
}

class Book {
    infix fun on(desk: Desk): Boolean {
        return desk.contains(this)
    }
}

class Desk {
    private val goods: Collection<Any> = Collections.emptyList()
    infix fun contains(any: Any): Boolean {
        return goods.contains(any)
    }
}

class Client {
    val book = Book()
    val desk = Desk()

    fun judge() {
        if (book on desk) {

        } else {

        }
    }
}

fun main(args: Array<String>) {
    //testMString()

    val c1 = Complex(3.0, 4.0)
    val c2 = Complex(1.0, 2.0)
    println(c1 + c2)

    println(args.indexOf("-name"))
//    println(args[args.indexOf("-name") + 1])
}

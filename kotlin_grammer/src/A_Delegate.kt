/**
 * 委托
 */
fun main() {

    val bb1: BB1 = object : BB1 {
        override fun print() {
            print("in object bb1")
        }
    }
    val cC1 = CC1(bb1)
    cC1.print()
}

interface BB1 {

    fun print() {
        println("in BB1")
    }
}

/**
 * CC1的所有方法都同作bB1来实现
 */
class CC1(bB1: BB1) : BB1 by bB1
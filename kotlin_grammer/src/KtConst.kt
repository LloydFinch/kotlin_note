/**
 * 运行时常量
 */
class KtConst {
    companion object {
        const val a = 20

        init {
            println("this is init")
        }
    }
}

fun main() {
    println(KtConst.a)
}

package mooc_demo.face_object

/**
 * kotlin内部类默认是是静态的，加inner是非静态的
 */
fun main(args: Array<String>) {

    //匿名内部类
    val fuck = object : Fuck {
        override fun onFuck() {
            println("fuck!!!")
        }
    }

    //匿名内部类实现继承
    var fuck2 = object : Outer(), Fuck {
        override fun onFuck() {

        }
    }

    //跟上面fuck2一样，只是调整了继承顺序
    val fuck3 = object : Fuck, Outer() {
        override fun onFuck() {

        }
    }

    //匿名内部类实现多个接口2333
    val fuck4 = object : Outer(), Fuck, Fuck2 {
        override fun onFuck() {

        }

        override fun onFuck2() {

        }
    }

}

open class Outer {
    val a = 10

    //静态内部类
    class Inner {
        fun test() {

        }
    }

    //非静态内部类
    inner class Inner1 {
        fun test() {
            //非静态内部类访问外部类成员
            println(a)
            println(this@Outer.a)
        }
    }
}

interface Fuck {
    fun onFuck()
}

interface Fuck2 {
    fun onFuck2()
}
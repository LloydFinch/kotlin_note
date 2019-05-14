package mooc_demo.face_object

/**
 * 数据类(默认实现copy,toString方法)
 * allOpen, noArg插件给data class生成五参构造方法
 */
fun main(args: Array<String>) {
    val china = Country(0, "china")
    println(china) //data class直接重写了toString()，会打印规则的数据

    //component1/2/3...会按照构造参数顺序打印
    println(china.component1()) //id
    println(china.component2()) //name

    //类似与react的解构赋值，实现原理就是依次按照componentX来赋值，见自定义例子
    val (id, name) = china
    val (id1) = china
    println(id)
    println(id1)
    println(name)

    //自定义component实现解构赋值
    val componentX = ComponentX()
    val (a, b, c, d) = componentX //必须有足够数量的component，否则编译期错误
    println("$a,$b,$c,$d")

    //这种写法跟 val (id,name) = china 一样
    for ((index, value) in args.withIndex()) {
        println(index)
        println(value)
    }

    //使用普通类试一下解构赋值
//    val (id2, name2) = TAA() //直接报错，因为非data类不会生成component属性
}

data class Country(val id: Int, val name: String)

class ComponentX {

    operator fun component1(): String {
        return "hello"
    }

    operator fun component2(): String {
        return "android"
    }

    operator fun component3(): String {
        return "java"
    }

    operator fun component4(): String {
        return "kotlin"
    }
}

class TAA(val id: Int, val name: String)
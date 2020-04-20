import javax.xml.crypto.Data

/**
 * 数据类
 */

fun main() {


    val data2: Data1 = Data1("12345", "data2")
    println(data2)

    /**
     * 数据类的toString()是不一样的，会自动生成
     */
    val data1: DataT = DataT("12345", "dataT", data2)
    data1.age = 20
    println(data1)
    println("data1.age:" + data1.age)


    /**
     * copy函数可以直接赋值，可以指定属性，是浅拷贝
     */
    val data3 = data1.copy(id = "45678")
    println(data3)
    println("data3.age:" + data3.age)

    data1.data1.name = "newData1"
    println(data1)
    println(data3)

    /**
     * 数据类的结构赋值
     */
    val (id, name) = data1
    println(id)
    println(name)

    println()
    /**
     * 结构赋值的内部实现就是component函数
     */
    val (id2, name2) = data1.data1
    println(id2)
    println(name2)


    /**
     * 标准数据类
     */
    val pair: Pair<String, String> = Pair("hello", "world")
    val triple: Triple<String, String, Int> = Triple("1", "2", 3)
}

/**
 *
 * @property id String
 * @constructor
 *
 * 编译器自动从主构造函数中声明的所有属性导出以下成员：
equals()/hashCode() 对；
toString() 格式是 "User(name=John, age=42)"；
componentN() 函数 按声明顺序对应于所有属性；
copy() 函数（见下文）。

数据类必须满足以下要求：

主构造函数需要至少有一个参数；
主构造函数的所有参数需要标记为 val 或 var；
数据类不能是抽象、开放、密封或者内部的；
（在1.1之前）数据类只能实现接口
 */
data class DataT(val id: String, var name: String, var data1: Data1) {
    var age = 0
}

class Data1(val id: String, var name: String) {

    override fun toString(): String {
        return name
    }

    operator fun component1(): String {
        return id
    }

    operator fun component2(): String {
        return name
    }
}
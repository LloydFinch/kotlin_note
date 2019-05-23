/**
 * kotlin集合跟java类似
 * 唯一区别就是有可变与不可变之分
 */
fun main() {
    tList()
}

fun tList() {

    //不可变List,只可读
    val list = listOf(1, 2, 3)
//    list.add(5) // error
    println("size = ${list.size}")
    //可变List，可读写
    val mutableList = mutableListOf(1, 2, 3)
    val add = mutableList.add(5) //ok, add = true
    println("add = $add")

}
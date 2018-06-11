package algorithm

import sun.net.www.protocol.http.HttpURLConnection
import java.util.*

class InsertSort {

}

fun main(args: Array<String>) {
    //array的构造，第二个闭包的index是下标
    val size = 6
    var array = Array(size, { index ->
        when (index) {
            in 0 until size -> size - Math.ceil(index.toDouble()).toInt()
            else -> 1
        }
    })

    //test()
    printt(array)
    println("----------split line----------")
    insertSort(array)
    printt(array)

    var array2 = Array(size, { index ->
        (size - index).toString() + "123"
    })
    printt(array2)
    println("----------split line----------")
    insertationSort(array2)
    printt(array2)
}

private fun <AnyType : Comparable<AnyType>> insertSort(items: Array<AnyType>) {
    var temp: AnyType
    var currentIndex: Int
    for (index in 0 until items.size) {
        temp = items[index]
        currentIndex = index
        for (currentIndex in index downTo 0) {
            if (temp < items[currentIndex]) {
                items[currentIndex + 1] = items[currentIndex]
            }
        }
        items[currentIndex] = temp
    }
}

private fun <AnyType : Comparable<AnyType>> insertationSort(items: Array<AnyType>) {
    var temp: AnyType
    var index: Int
    for (i in items.indices) {
        temp = items[i]
        index = i
        while (index > 0 && temp < items[index - 1]) {
            items[index] = items[index - 1]
            index--
        }
        items[index] = temp
    }
}


private fun <AnyType> printt(items: Array<AnyType>) {
    items.forEach { it -> println(it) }
}

private fun test() {
    for (temp in 10 downTo 1) {
        println(temp);
    }
}

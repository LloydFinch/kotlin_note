package algorithm

fun main(args: Array<String>) {
    //println(aplusb(1, 2))
    println(trailZeros(105))
}


/**
 * 不使用+计算a+b
 * 不考虑溢出问题
 */
fun aplusb(a: Int, b: Int): Int {
    if (b == 0) {
        return a
    }
    var xorTemp = a xor b;
    var shiftTemp = (a and b) shl (1)
    return aplusb(xorTemp, shiftTemp)
}

/**
 * 计算尾部的0的个数(考虑O(n))
 * transfer:求几个5的问题
 */
fun trailZeros(n: Long): Long {
    var sum: Long = 0
    var num = n;
    while (num > 0) {
        num /= 5
        sum += num
    }
    return sum
}
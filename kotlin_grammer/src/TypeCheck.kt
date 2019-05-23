/**
 * is/!is/as/as?
 */
fun main() {
    val number: Number = 10
    if (number is Int) {
        val count: Int = number
    }

    //如果number不为null就转换为Long，否则返回null
    //所以temp是Long?类型的
    val temp: Long? = number as? Long
}
package firstlinecode

/**
 *
 * Name: String
 * Author: lloydfinch
 * Function: 定义String的扩展函数
 * Date: 2020-04-27 13:54
 * Modify: lloydfinch 2020-04-27 13:54
 */

/**
 * 计算String中letter出现的次数
 * @receiver String
 * @return Int String中letter出现的次数
 */
fun String.letterCount(): Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}


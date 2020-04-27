package mooc_demo.face_object

/**
 * 密封类，等价于private open的class，保护不被其他文件访问
 */
fun main(args: Array<String>) {

}

sealed class PlayerCmd {
}

class Play(val url: String, val position: Long = 0) : PlayerCmd()

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * kotlin协程
 */

suspend fun main() {

//    testR1()
//    testR1Eq()

    testWaitCallback()
}


fun testR1() {

    GlobalScope.launch {
        // 在后台启动一个新的协程并继续
        delay(1000L) //非阻塞的等待 1 秒钟（默认时间单位是毫秒）
        println("World!") // 在延迟后打印输出
    }
    println("Hello,") // 协程已在等待时主线程还在继续
    Thread.sleep(2000L) //阻塞主线程 2 秒钟来保证 JVM 存活

}

fun testR1Eq() {
    GlobalScope.launch {
        // 启动一个协程
        delay(1000)
        println("world")
    }
    println("hello")
    //阻塞调用
    runBlocking {
        delay(2000)
    }
}

/**
 * 等待结束，使用了join，不具备参考价值
 */
suspend fun testWaitCallback() {
    val job = GlobalScope.launch {
        delay(1000)
        println("after 1000 in job")
    }

    println("start")
    job.join()
    println("end")
}













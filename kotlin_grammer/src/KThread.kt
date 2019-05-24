import kotlin.concurrent.thread

/**
 * kotlin协程
 */

fun main() {
    testK1()
}

/**
 * kotlin使用线程，类似于java
 */
fun testK1() {
    thread {
        Thread.sleep(1000)
        println("after sleep 1000ms in ${Thread.currentThread().name}")

    }

    println("hello, in ${Thread.currentThread().name}")

    val t1 = Thread {
        println("in thread ${Thread.currentThread().name}")
    }
    t1.join()
    t1.start()

    println("hello2 after t1 in ${Thread.currentThread().name}")
}
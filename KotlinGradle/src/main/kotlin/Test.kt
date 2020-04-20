import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {

//    val coroutines = TestCoroutines();
//    coroutines.t4()


    test13()
}


fun test() {
//
//    GlobalScope.launch {
//        delay(1000L)
//        println("world")
//    }

    println("hello")

    /**
     * 用于阻塞当前线程(Thread.sleep(2000))
     */
    runBlocking {
        delay(2000)
        println("delay 2000 ${Thread.currentThread().name}")
    }

    /**
     * 开启新协程 new Thread(){run(Thread.sleep(1000))}
     */
    GlobalScope.launch {
        delay(1000)
        println("delay 1000 ${Thread.currentThread().name}")
    }


    println("test end")


    runBlocking {
        delay(3000)
    }

}


fun test2() {

    GlobalScope.launch {
        println("coroutines1")
    }

    println("start")

    GlobalScope.launch {
        println("coroutines2")
    }

    println("after")


    runBlocking {
        delay(1000)
    }

    println("end")
}


fun test3() {
    fun testt() = runBlocking {

        launch {
            delay(300)
            println("delay 300 ${Thread.currentThread().name}")
        }

        println("before coroutineScope")

        /**
         * 这个会挂起当前线程，只是挂起不是阻塞(runBlocking是阻塞),
         * 等到作用域跑完之后才会恢复
         */
        coroutineScope {
            launch {
                delay(500)
                println("delay 500 ${Thread.currentThread().name}")
            }


            delay(100)
            println("delay 100 ${Thread.currentThread().name}")
        }

        launch {
            delay(400)
            println("delay 400 ${Thread.currentThread().name}")
        }

        /**
         * 这一行会在coroutineScope{}执行完毕后才输出
         */
        println("coroutine scope over ${Thread.currentThread().name}")

    }

    testt()
}

/**
 * 协程可以提取成函数
 */
fun test4() = runBlocking {

    launch {
        doLaunch()
    }

    println("end")

}

private suspend fun doLaunch() {
    delay(1000)
    println("delay 1000")
}


/**
 * 协程很轻量
 */
fun test5() = runBlocking {
    repeat(10_000) {
        launch {
            delay(1000)
            println(".")
        }
    }

}


/**
 * 全局协程像守护线程
 * 在GlobalScope中激活的协程不会使进程保活，类似守护线程
 */
fun test6() = GlobalScope.launch {
    repeat(1000) {
        println("sleep...$it")
        delay(500)
    }
    delay(2000)
}


/**
 * 协程的取消
 */
fun test7() = runBlocking {

    val job = launch {
        repeat(1000) {
            println("sleep $it")
            delay(500)
        }
    }
    delay(1600)

    /**
     * 取消协程
     */
//    job.cancel()
//    job.join()

    job.cancelAndJoin()

}

/**
 * 协程的取消是协作的
 */
fun test8() = runBlocking {

    val startTime = System.currentTimeMillis();
    val job = launch(Dispatchers.Default) {
        val num = 10
        var nextTime = startTime
        /**
         * 这里添加isActive来进行判断是否需要继续(类似于Thread.isInterrupt())
         */
        while (num < 100 && isActive) {
            if (System.currentTimeMillis() >= nextTime) {
                println("sleep...")
                nextTime += 500
            }
        }
    }


    delay(1300)
    println("start cancel job")
    job.cancelAndJoin()
    println("quit func")
}


/**
 * 跟线程类似，需要处理取消时异常(Thread的中断异常)
 */
fun test9() = runBlocking {

    val job = launch {
        try {
            repeat(1000) {
                println("len $it")
                delay(500)
            }
        } finally {
            withContext(NonCancellable) {
                println("running in finally")
                delay(1000)
                println("non cancellable, so delay 1000")
            }
        }
    }

    delay(1300)
    println("start cancel")
    job.cancelAndJoin()
    println("quit func")
}

/**
 * 超时
 * withTimeout超时抛出异常
 * withTimeout超时会返回null，不会抛出异常
 */
fun test10() = runBlocking {
    val result = withTimeoutOrNull(1300) {
        repeat(10) {
            println("sleep...")
            delay(100)
        }
        "Done" //如果没有超时，返回"Done"
    }

    println("result = $result")
}


/**
 * 调用顺序
 */
fun test11() = runBlocking {

    val time = measureTimeMillis {
        /**
         * 这俩默认是串行的，会挨个调用，
         * 一个跑完跑另一个
         */
        val v1 = request1()
        val v2 = request2()

        println("result = ${v1 + v2}")
    }

    println("finish in time $time ms")

}

/**
 * 使用async，跟launch一样也是启动一个新的协程，
 * 但是他会返回一个Deffered，这是一个轻量级的future，也是
 * 一个job
 */
fun test12() = runBlocking {

    val time = measureTimeMillis {
        /**
         * 使用async并发执行
         */
//        val v1 = async { request1() }
//        val v2 = async { request2() }

        /**
         * 使用CoroutineStart.LAZY参数，只有调用start()或await()时才会开始执行
         */
        val v1 = async(start = CoroutineStart.LAZY) { request1() }
        val v2 = async(start = CoroutineStart.LAZY) { request2() }

        /**
         * 这里的await()是串行的
         */
        println("result = ${v1.await() + v2.await()}")
    }

    println("finish in time $time ms")
}

/**
 * async函数
 */
fun test13() {

    val time = measureTimeMillis {
        val v1 = request1Async()
        val v2 = request2Async()

        runBlocking {
            println("result  = ${v1.await() + v2.await()}")
        }
    }

    println("finish in time $time ms")
}

fun request1Async() = GlobalScope.async {
    request1()
}

fun request2Async() = GlobalScope.async {
    request2()
}


suspend fun request1(): Int {
    delay(1000)
    return 10
}

suspend fun request2(): Int {
    delay(2000)
    return 11
}








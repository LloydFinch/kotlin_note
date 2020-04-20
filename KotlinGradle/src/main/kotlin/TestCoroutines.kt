import kotlinx.coroutines.*

class TestCoroutines {

    /**
     * 测试协程
     */
    fun testCoroutines() {
        GlobalScope.launch {
            // 在后台启动一个新的协程并继续
            delay(1000L)  //非阻塞的delay
            println("World!")
        }
        println("Hello,") // 主线程中的代码会立即执行

        //这里是一个阻塞的delay
        runBlocking {
            // 但是这个表达式阻塞了主线程
            delay(2000L)  // ……我们延迟 2 秒来保证 JVM 的存活
        }
    }


    fun t1() {

        println("start")

        GlobalScope.launch {
            delay(1000L)
            println("1000ms ${Thread.currentThread().name}")
        }
        println("end")

        runBlocking {
            delay(2000L)
        }
    }

    /**
     * 串行执行,后面结果依赖前面
     */
    fun t2() {

        println("start t2")

        GlobalScope.launch {
            val v1 = request1()
            val v2 = request2(v1)
            val v3 = request3(v2)

            updateUI(v3)

        }

        println("end t2")


        /**
         * 防止JVM退出
         */
        runBlocking {
            delay(10000)
        }
    }

    /**
     * 并行执行,等待多个任务执行完毕
     */
    fun t3() {

        println("start t3")

        GlobalScope.launch {
            val v1 = async { res1() }
            val v2 = async { res2() }
            val v3 = async { res3() }

            endFunc(v1.await(), v2.await(), v3.await())
        }


        println("end t3")


        /**
         * 防止JVM退出
         */
        runBlocking {
            delay(5000)
        }



        println("end t3")
    }

    fun t4() {

        fun test() = runBlocking {
            //            val job = GlobalScope.launch {
//                delay(1000)
//                println("world")
//            }
            launch {
                delay(100)
                println("world")
            }

            delay(1000)

            println("hello")
//            job.join()
        }

        test()
    }


    fun request1(): Int {

        runBlocking {
            delay(1000)
        }

        return 100
    }

    fun request2(num: Int): Int {
        runBlocking {
            delay(2000)
        }
        return num + 1
    }

    fun request3(num: Int): Int {
        runBlocking {
            delay(3000)
        }
        return num shl 1
    }

    fun updateUI(num: Int) {
        println("result is $num")
    }


    fun res1(): Int {
        runBlocking {
            delay(100)
        }
        return 100
    }

    fun res2(): Int {
        runBlocking {
            delay(100)
        }
        return 200
    }

    fun res3(): Int {
        runBlocking {
            delay(100)
        }
        return 300
    }

    fun endFunc(v1: Int, v2: Int, v3: Int) {
        println("v1:$v1, v2:$v2, v3:$v3")
    }

}
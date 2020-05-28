//import kotlinx.coroutines.*
//
///**
// *
// * Name: TestK
// * Author: lloydfinch
// * Function: Coroutine
// * Date: 2020-05-25 17:17
// * Modify: lloydfinch 2020-05-25 17:17
// */
//
//fun printlnThreadName() {
//    println(Thread.currentThread().name)
//}
//
//fun main() {
////    testCoroutine1()
//    testCoroutine2()
//
//
//    Thread.sleep(1000)
//}
//
//
///**
// * 使用Global.launch()切换线程
// */
//fun testCoroutine1() {
//    val job = GlobalScope.launch(Dispatchers.IO) {
//        printlnThreadName()
//        GlobalScope.launch(Dispatchers.Main) {
//            printlnThreadName()
//        }
//    }
//
//    //取消协程
//    job.cancel()
//}
//
///**
// * 使用withContext()切换线程
// */
//fun testCoroutine2() {
//    GlobalScope.launch(Dispatchers.IO) {
//        printlnThreadName()
//        println("switch to io")
//        val result = withContext(Dispatchers.Main) {
//            printlnThreadName()
//            println("switch to main")
//            "hello"
//        }
//        println(result)
//    }
//}
//
///**
// * 使用suspend
// */
//fun testCoroutine3() {
//    GlobalScope.launch(Dispatchers.Default) {
//        val result = getData()
//        println(result)
//    }
//}
//
///**
// * 流式接力调用
// */
//fun testCoroutine4() {
//    GlobalScope.launch(Dispatchers.Main) {
//        val token = token()
//        val id = register(token)
//        val login = login(id)
//        println("login = $login")
//    }
//}
//
//suspend fun token(): String {
//    withContext(Dispatchers.IO) {
//
//    }
//}
//
//suspend fun register(token: String): String {
//    withContext(Dispatchers.IO) {
//
//    }
//}
//
//suspend fun login(id: String): Boolean {
//    withContext(Dispatchers.IO) {
//
//    }
//}
//
///**
// * 结果合并
// */
//fun testCoroutine5() {
//    GlobalScope.launch(Dispatchers.Main) {
//        val one = async { one() }
//        val two = async { two() }
//        val result = one.await() + two.await();
//    }
//}
//
//fun one(): Int {
//
//}
//
//fun two(): Int {
//
//}
//
//
//suspend fun getData(): String {
//    val result: String = withContext(Dispatchers.IO) {
//        result()
//    }
//    return result
//}
//
//fun result(): String {
//    return "result"
//}
//
//
//
//
/////////////////////////////////////
//
//
//
//
//
//
//
//
//
//

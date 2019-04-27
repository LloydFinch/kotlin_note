package net.http

fun main(args: Array<String>) {

    val doGet = Thread {
        run {
            val data = HttpTools.doGet("http://www.baidu.com");
            val content = String(data);
            println(content)
        }
    }

    doGet.start()

}
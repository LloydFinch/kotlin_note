package test

lateinit var a: A
fun main(args: Array<String>) {
    //SmallHeadFather().washBowl()

    //var a = SmallHeadFather
    //var b = SmallHeadFather


    //println(a == b)

    //println(a.name)

    var c = 8

    if (Config.a < Config.b) {
        if (c > (8 ushr 1)) {
            c -= ((Config.b - Config.a) ushr 1)
        }
    }
    println(c)

}

class A {
    var name: String = "hello"
}
import java.math.BigInteger
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main(args: Array<String>) {

    args.forEach { println(it) }
    args.forEach(::println)
    test();
    //testType();
    //testParse();
    //testArray()
    //testString();
    //testControlFlow(11);
    //testFor();
    //testJump();
    //testClassInitOrder();
    //testClassExtends();
    //testExtendFunction();
    //test2();
    //testDataClass();
    //testComponent();
    //testTypeReflection();
    //testObjectExpression();
    //testCompanion();
    //testDelegate();
    //testPropertyDelete();
    //testStandardDelegate();
    //testFunction();
    //testFunction2();
    //testPractice();
    //   test222();

    //testStrCompare()
    //testList1()
    //testInput()

    //println(testFact(BigInteger("100")))

    //var result = 0
    //println(ollTest(1000, result))

    testNan();
}

fun test() {
    println("hello kotlin!");
}

fun testType(): Unit {
    val a: Boolean = true// int a=10000
    // val b:Int?=1000000 // Integer b=new Integer(10000)


    val boxedA: Boolean = a; // Integer boxedA = Integer.valueOf(1000)
    val boxedA2: Boolean = a;

    println("A===A2: ${boxedA === boxedA2}");
    println("A==A2: ${boxedA == boxedA2}");

    val b: String = "aaaaaaaaa";
    val boxedB: String = b;
    val boxedB2: String = b;


    println("B===B2: ${boxedB === boxedB2}");
    println("B==B2: ${boxedB == boxedB2}");
}

fun testParse(): Unit {
    var b: Byte = 10;
    var i: Int? = 20;

    i = b.toInt();

    println("b=$b,i=$i");
}

fun testArray(): Unit {
    var a1: Array<Int> = arrayOf(1, 2, 3, 4, 5);//创建一个数组
    val a2 = arrayOfNulls<Int>(5);//创建一个数组，大小为5，所有元素为null

    println(a1);
    println(a2);

    println(a1[1]);//[]调用了Array的get函数
    a1[1] = 10;//[]调用了Array的set函数
    println(a1[1]);//[]调用了Array的get函数

    println(a2[2])
    a2[2] = 10;
    println(a2[2]);


    var a3 = Array(5, { i -> i * i });//使用构造函数获取数组,i使用索引值
    for (i in a3) {
        println(i);
    }

    var a4 = intArrayOf(1, 2, 3, 4, 5, 6);//无需装箱的数组
}

fun testString() {
    //原生字符串,使用"""str"""括起来,可以原模原样打印出字符串
    var str = """hello
        |android
        |java
    """.trimMargin();

    println("native String: $str");


    var str1 = "    hello   kotlin!    ".trimMargin();
    println(str1);
}

fun testControlFlow(b: Int = 5) {
    //if语句作为表达式代替条件表达式
    val a = if (b > 10) b else 10;
    println(a);

    //when用作表达式，必须有else；用作语句，可以没有else
    val w = when (b) {

        in 1..4 -> 4;
        !in 1..4 -> b;
        1, 2, 3 -> 3;//多个条件
        5 -> 5;
        else -> 10;
    }

    println("w=$w");

    //局部函数，when 作为表达式，必须有else分支
    fun hasPrefix(s: Any) = when (s) {
        is String -> if (s.startsWith("prefix")) println("start with prefix") else println("not start with prefix");
        else -> println("has no prefix!");
    }

    var s: String = b.toString();
    hasPrefix(s);
}

fun testFor() {
    //通过索引遍历list
    var list = listOf<String>("a", "b", "c", "d");
    for (i in list.indices) {
        println(list[i]);
    }
    //(index,value)方式遍历list
    for ((index, value) in list.withIndex()) {
        println("$index element is $value");
    }

    //遍历map
    var map = mapOf<Int, String>(1 to "hello", 2 to "world");
    for ((index, value) in map) {
        println("$index = $value");
    }
}

fun testJump() {

    //跳转到标签处
//    var a = intArrayOf(1, 2, 3, 4, 5, 6);
//    goto@ for (i in a) {
//        if (i < 4) continue@goto
//        println(i);
//    }

    //返回标签处, lambda表达式如果不加标签，则会直接从当前函数返回
    var list = listOf<Int>(1, 2, 3, 4, 5, 6);
    list.forEach lint@{
        //        if (it > 2) {
//            println(it);
//        }
        if (it <= 2) {
            return@lint;
        }
        println(it);
    }

    //使用隐式标签
    list.forEach({ if (it > 2) println(it) else return@forEach })

    //使用匿名函数替代lambda支持局部返回
    list.forEach(fun(value: Int) {
        if (value > 2) {
            println(value);
        } else {
            return;
        }
    })

    //局部返回,不是返回到forEach()而是返回到loop
    run loop@{
        list.forEach({ if (it > 2) println(it) else return@loop })

        //return@loop 1;//表示返回到标签处,返回值为1
    }
}

fun testClassInitOrder() {
    // 创建类的实例，不需要使用new关键字，只需要像调用普通函数一样调用构造函数即可
    //var smaple = InitSample("android");
    var sample2 = InitSample("android", 20);
}

class InitSample(name: String = "hello") {
    var s = name.toUpperCase();//类块中可以直接使用主构造函数中的参数
    val str1 = "this is first init $name";

    init {
        println(str1);
        println(name);//初始化块中可以直接使用主构造函数中的参数
    }

    val str2 = "this is second init $name";

    init {
        println(str2);
    }

    //次构造函数，必须手动调用一下主构造函数
    constructor(name: String, age: Int) : this(name) {
        println("name is $name, age is $age!");
    }
}

fun testClassExtends() {
    var child = Child3("hello", 10);
    println("id is ${child.id}");
    child.baseTest();
    child.baseTest2();
    child.test();
}

//使用open使得可以作为基类
open class Base(name: String) {
    open var id: String = "123456";
    open var age: Int = 20;

    //此方法要被覆盖，需要声明为open类型
    open fun baseTest() {
        println("this is base function!");
    }

    open fun baseTest2() {
        println("this is base function2!");
    }
}

//子类继承父类需要实现其主构造函数
open class Child(name: String) : Base(name) {
    //覆盖父类的属性,并且声明为final防止再次被覆盖
    final override var id: String
        get() = super.id
        set(value) {}

    //不能使用val覆盖var属性，反之可以，因为：
    //1 var有getter和setter,val只有getter，可以使用多的覆盖少的，不能使用少的覆盖多的
//    override val age: Int
//        get() = super.age
//        set(value) {}


    //覆盖父类中的方法，使用override关键字
    override fun baseTest() {
        println("this is child function!");
    }

    //声明为final，防止再次被覆盖
    final override fun baseTest2() {
        println("this is child function2!");
    }
}

open class Child2(name: String) : Child(name) {
    open var address: String = "beijing";
    //不能再覆盖父类的id属性，因为已经被声明为final类型
//    override var id: String
//        get() = super.id
//        set(value) {}

    override fun baseTest() {
        super.baseTest();
        println("override from Child but Base");
    }

    //不能再覆盖此函数，因为已经在父类中被声明为final的
    //override fun baseTest2() {}
}

//在构造主函数中直接使用override关键字覆盖age属性
class Child3(name: String, override var age: Int) : Child2(name) {

    //覆盖基类中的address属性
    override var address: String = "shanghai";

    fun test() {
        val child = Child3Inner();
        child.test();
    }

    inner class Child3Inner {
        fun test() {
            //访问外部类的address属性
            println("address is $address");
            //访问外部类的基类的address属性
            println("supper address is ${super@Child3.address}");
        }
    }

}

open class A {
    open fun f() {};
}

interface B {
    fun f() {};
}

class C : A(), B {

    //多个超类需要使用super<Base>来指明访问的是哪个类中的成员
    override fun f() {
        super<A>.f();//超类A中的f()
        super<B>.f();//超类B中的f()
    };
}

//abstract类型的默认是open的
abstract class D {
    //abstract类型类型的方法可以不用实现
    abstract fun c();
}

class E : D() {

    //自定义getter和setter
    var name: String
        get() = "hello" + name
        set(value) {
            name = "hello" + value
        }

    var age: Int
        get() = age + 1;
        private set(value) {}//只定义不实现，改变可见性

    override fun c() {
        println("my age is $age");
    }
}

fun testClass2() {
    var test = Test();
    test.a;
}

class Test {
    var a = 10;
}

fun testExtendFunction() {

    //扩展函数,在可见域内可见
    fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
        var temp = this[index1];

        this[index1] = this[index2];
        this[index2] = temp;
    }

    var list = mutableListOf<Int>(1, 2, 3, 4, 5);
    list.forEach { it -> println(it) }

    println("--------------split line----------------");
    list.swap(1, 2)
    list.forEach { it -> println(it) }

}

//扩展属性，给所有类添加一个TAG属性，值为toString()
//使用: 运用在Android中给所有的Activity等需要TAG的class添加TAG
val Any.TAG: String
    get() = toString()

//给所有List添加一个lastIndex属性，值为最后一个元素的下标
val <T> List<T>.lastIndex: Int
    get() = size - 1;

//万能型扩展toString()
fun Any?.toString(): String {
    return this?.toString() ?: "fuck!!!";
}

fun test2() {
    var str = null;
    println(str.toString());
}

//数据类
data class Person(var name: String) {
    var age: Int = 10;

    //次构造函数，必须实现主构造函数
    constructor(name: String, age: Int) : this(name) {

    }
}

fun testDataClass() {
    var person1 = Person("tom");
    person1.age = 10;
    person1.name = "tom";

    var person2 = Person("tom");
    person2.age = 20;
    person2.name = "tom1";

    println("person1==person2:${person1 == person2}");
    println("person1.age:${person1.age}");
    println("person2.age:${person2.age}");

    var person3 = Person(name = "jack", age = 20);
    var person4 = person3.copy(name = "jack2");//复制了person3并改变了name属性，name属性必须在主构造中声明

    var (name) = person3;
}


data class User(var name: String, var age: Int) {

}

fun testComponent() {
    var user = User("jack", 20);

    var (name, age) = user;//数据类的解构声明,解构声明的属性必须在主构造中定义(有component()函数)

    println(name);
    println(age);
}

//测试类型投影
fun testTypeReflection() {

    //数组拷贝
    fun copy(from: Array<out Any>, to: Array<Any>) {
        assert(from.size == to.size);
        for (i in from.indices) {
            to[i] = from[i];
        }
    }

    var a1: Array<Int> = arrayOf(1, 2, 3, 4, 5);
    var a2: Array<Any> = arrayOf("a", "b", "c", "d", "e");
    copy(a1, a2);//error,因为Array<Int>不是Array<Any>的子类

    a2.forEach { it -> println(it) }
}

//泛型约束
fun testTypeLimit() {

    //泛型约束，约束了上界为Comparable<T>
    fun <T : Comparable<T>> test1() {

    }

    //使用where子句定义多个上界
    fun <T> test2() where T : Comparable<T>, T : Iterable<T> {

    }
}

open class AA {
    var type: String = "String";
    open var name: String = "AA";

}

//对象表达式
fun testObjectExpression() {

    //使用对象表达式简单的定义一个对象
    var node = object {
        var x: Int = 0;
        var y: Int = 0;
    }

    //声明一个AA类对象，可以进行多态
    var a = object : AA() {

        //复写了父类的name属性
        override var name: String
            get() = super.name
            set(value) {}

        //实现了自己的age属性并初始化
        var age: Int = 20;
    }

    println("type:${a.type},name:${a.name},age:${a.age}");
}

class Out {

    //可以省略名字
    companion object A {
        var a: Int = 10;
    }
}

fun testCompanion() {
    var out = Out();
    println(Out.a);//访问伴生对象的成员
}

//定义委托的接口
interface Base1 {
    fun show();
}

//定义被委托类
class B1 : Base1 {
    override fun show() {
        println("this is in B1");
    }
}

//定义委托类，B2会将所有Base1的方法委托给b去处理
class B2(b: Base1) : Base1 by b;

class B3(b: Base1) : Base1 by b {
    //如果实现了委托的方法，则以实现的为准
    override fun show() {
        println("this is in B3");
    }
}

fun testDelegate() {
    var b = B1();
    B2(b).show();//委托给b处理
    B3(b).show();//虽然有委托但是自己实现了，以自己实现的为准
}

class D1 {
    var hello: String by PropertyDelegate();
}

//属性委托器
class PropertyDelegate {

    //TODO 怎么获取值
    //d1: 委托对象的引用
    //property: 对委托对象的描述
    operator fun getValue(d1: D1, property: KProperty<*>): String {
        return "get ${property.name} from delegate!"
    }

    //TODO 怎么赋值
    //d1: 委托对象的引用
    //property: 对委托对象的描述
    //s: 赋的新值
    operator fun setValue(d1: D1, property: KProperty<*>, s: String) {
        println("set ${property.name} from delegate!");
    }
}

fun testPropertyDelete() {
    var d = D1();
    d.hello = "android";
    println(d.hello);
}

fun testStandardDelegate() {

    //1 延迟属性lazy: return之前的语句只在第一次调用的时候执行一次
    // lazy的初始化默认是加同步锁的
    val l: String by lazy {
        println("initial success!");
        "hello";
    }
    println(l);
    println(l);

    //2 可观察属性observable
    //如果需要过滤，可以使用vetoable()取代
    var temp: String by Delegates.observable("null") { property, oldValue, newValue ->
        println("${property.name}'s oldValue is $oldValue !");
        println("${property.name}'s newValue is $newValue !");
    };
    //两次赋值会触发监听函数
    temp = "hello";
    temp = "android";
    println(temp);

    //vetoable()返回一个Boolean，如果为true则赋值成功，否则不进行赋值
    var temp1: String by Delegates.vetoable("null") { property, oldValue, newValue ->
        println("${property.name}'s oldValue is $oldValue !");
        println("${property.name}'s newValue is $newValue !");
        newValue.length > 5;//只接受长度大于5的字符串
    };
    temp1 = "hello";//长度小于5赋值失败
    println(temp1);
    temp1 = "android";//长度大于5赋值成功
    println(temp1);

    //3 属性存放映射中
    class User(val map: Map<String, Any?>) {
        //这两个属性委托给map，将会从map中将属性作为key，并根据key取值
        val name: String by map;
        val age: Int by map;
    }

    //使用var属性需要配合MutableMap<>
    class MutableUser(val map: MutableMap<String, Any?>) {
        var name: String by map;
        var age: Int by map;
    }

    fun testPropertyIntoMap() {
        var user = User(mapOf("name" to "jack", "age" to 20));
        println("user.name = ${user.name}");
        println("user.age = ${user.age}");
    }

    testPropertyIntoMap();
}

fun testFunction() {
    //使用命名参数
    fun testNameFunction(name: String = "null", age: Int = 0, sex: String = "no") {
        println("name = $name, age = $age,sex = $sex");
    }
    testNameFunction(name = "hello", age = 10, sex = "man");
    testNameFunction("hello", 10, sex = "man");//混用
    //testNameFunction(name = "hello", 10, "man")//error,混用时命名参数必须在后面

    //中缀表示法，必须有且只有一个参数
    infix fun Int.shl1(bit: Int): Int {
        return shl(bit)
    }
    //一般调用
    println(2.shl1(1));
    //中缀表示法调用，省略了.和()
    println(2 shl1 1);
    //中缀表示法，省略了.
    println(2 shl1 (1));
    //println(2.shl1 1);//error 不能只省略()


    //尾递归函数
    tailrec fun test1(i: Int = 10): Int = if (i <= 2) i else test1(i shr 1);

    println(test1(2));
}

fun testFunction2() {

    //匿名函数
    fun add(a: Int, b: Int): Int = a + b;

    //函数类型变量
    var sum1: (Int, Int) -> Int;//定义一个函数类型变量
    var sum: (Int, Int) -> Int = { x, y -> x + y };//定义一个函数变量并初始化
    var test: () -> String = { "hello" };
    println(sum(3, 4));

    var sum2: Int.(other: Int) -> Int = { x -> this + x };
    var int1: Int = 10;
    println(int1.sum2(2));

    //使用匿名函数的更简练的写法，视为函数扩展的简练版
    var sum3 = fun Int.(other: Int): Int = this + other;
    var pre = fun String.(pre: String): String = pre + this;//扩展一个添加前缀的方法
    println(1.sum3(2));
    println("android".pre("hello "));

}


fun testPractice() {

    //函数型变量
    var fun0: (Int, Int) -> Int = { x, y -> x + y };

    //匿名函数
    fun sum(x: Int, y: Int): Int = x + y;

    fun sum1(x: Int, y: Int): Int {
        return x + y;
    }

    //将匿名函数赋值给函数型变量
    var funNoName = fun(x: Int, y: Int): Int = x + y;//等价于下面的写法
    var funNoName1 = fun(x: Int, y: Int): Int { return x + y };

    //函数型变量交换list变量的值
    var swapByIndex = fun(list: MutableList<Any>, index1: Int, index2: Int) {
        assert(index1 < list.size && index2 < list.size);
        println("execute into there...");
        val temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
        println(temp);
    }
    var list = mutableListOf<Any>(1, 2, 3, 4, 5);
    println(swapByIndex(list, 0, 1));
    list.forEach { it -> print("$it ") };//useless
    println();

    println("funNoName1(1,2) is ${funNoName1(1, 2)}");
}

//数据类类中定义的属性必须初始化，初始化为null必须声明为?可空类型
//数据类的一系列自动生成方法只包含在主构造中声明的属性
data class User12(var id: String) {
    var name: String = "";
    var sex: Int = 0;
    var address: String? = null;

    //数据类中重写super的方法，使之包含类体中添加的属性
    override fun toString(): String {
        return "User12(id='$id', name='$name', sex=$sex, address=$address)"
    }
}

//定义一个类，类中属性可以在声明的时候不初始化，使用lateinit延迟初始化，在使用的时候再初始化
class User22 {

    //使用延迟加载属性，在使用时才初始化
    lateinit var id: String;
    lateinit var name: String;
    lateinit var address: String;

    override fun toString(): String {
        return "User22(id='$id', name='$name', address='$address')"
    }
}


fun test222() {

    var user1 = User12("00001");
    user1.name = "jack";
    user1.sex = 1;
    user1.address = "beijing";
    println(user1);

    var user = User22();
    user.id = "00002";
    user.name = "tom";
    user.address = "shanghai";
    println(user);
}


fun testStrCompare() {
    var str = "hello"
    var str1 = "hEllo"
    println(str == str1)
    println(str.equals(str1, true))
}

fun testList1() {
    var lists = listOf("t1", "t2", "t3", "t4");
    for ((i, e) in lists.withIndex()) {
        println("$i, $e");
    }
}

fun testInput() {
    println("Please input first number:")
    var num1 = readLine()!!.toInt()
    println("Please input second number:")
    var num2 = readLine()!!.toInt()
    println("$num1+$num2=${num1 + num2}");
}

fun testFact(num: BigInteger): BigInteger {
    return if (num.toInt() <= 1) {
        BigInteger.ONE
    } else {
        num * testFact(num - BigInteger.ONE)
    }
}

//尾调，避免栈溢出
tailrec fun ollTest(num: Int, result: Int): Int {
    println(result)
    return if (num != 0) {
        ollTest(num - 1, result + num)
    } else {
        num
    }
}


fun testNan() {
    val nan = Float.NaN
    val q = 0.0f / 0.0f
    println(nan == nan);//false
}

var far = fun(a: Int, b: Int): Int {
    return a + b
}

var far2 = { a: Int, b: Int -> (a + b) }

var fun3: (Int, Int) -> Int = { x, y -> x + y }
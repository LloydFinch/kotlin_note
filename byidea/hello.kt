

fun main(args: Array<String>){

	println("hello ,world!");


	println(sum(2,3));
	println(sum1(3,4));
	println(sum2(4,5));
	
	//可变长的参数
	vars(1,2,3,4,5);

	println(sumLambda(1,9));


	strTest();

	testRange();

	testCompare();
	testCompares();

	
}


fun sum(a: Int, b: Int): Int{
	return a+b;
}


fun sum1(a: Int, b: Int) = a+b;

public fun sum2(a: Int,b: Int) = a+b;

fun vars(vararg v: Int){
	for(vt in v){
		println(vt);
	}
}

val sumLambda: (Int, Int) -> Int = {x,y -> x+y};

fun strTest(){
	var a = "hello";
	
	println("test is $a");
	
	println("test is ${a.replace("h","y")}");
}

//测试区间
fun testRange(){
	for(i in 1..4){
		print(i);
	}
	println();

	for(i in 4 downTo 1){
		print(i);
	}
	println();

	for(i in 1..4 step 2){
		print(i);
	}
	println();

	for(i in 1 until 4){
		print(i);
	}
	println();
}

//测试==和===
fun testCompare(){
	var a: Int  = 10000;//[-127-128]之间不会创建新对象
	var b: Int? = a;
	var c: Int? = a;	

	println("b==c:  ${b==c}");
	println("b===c: ${b===c}");
}


fun testCompares(){

	var a: String = "hello";
	var b: String? = a;
	var c: String? = a;

	var d: String = "hello";

	var e = String("test")
	var f = String("test");
	
	println("b==c:  ${b==c}");
	println("b===c: ${b===c}");

	println("a===d: ${a===d}");
	println("b===d: ${b===d}");

	println("e==f:  ${e==f}");
	println("e===f: ${e===f}");
}












fun main(args: Array<String>){
	
	var box: Box<Int> = Box<Int>(1);
	var box2 = Box(1);//编译器自动判断类型,不用指明类型

	//eg for genericity
	var boxInt: Box<Int> = Box<Int>(1);
	var boxString: Box<String> = Box<String>("hello");

	println(boxInt.value);
	println(boxString.value);

	println(boxIn(123).value);
	println(boxIn("world!").value);

	test(100);
	test("hello android!");


	testWhen(123);
	testWhen("hello");
	testWhen(true);
}


//state a genericity class
class Box<T>(t: T){
	var value = t;
	
}

//state a genericity function
fun <T> boxIn(value: T) = Box(value);

fun <AnyType> test(param: AnyType){
	println("this param is $param");
}

fun <AnyType> testWhen(param: AnyType){
	when(param){
		
		is Int -> println("this is a Int value");
		is String -> println("this is a String value");
		else -> println("this value is neither a Int nor a String");
	}
}













fun mian(args: Array<String>){




}

//test in/out
class TestOut<out T>(val t: T){
	fun test(): T{
	
		return t;
	}

}

class TestIn<in T>(t: T){

	fun test(a: T){

		//return t;
	}

}
















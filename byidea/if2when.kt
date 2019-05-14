
fun main(args: Array<String>){

	testIf();
		
	testWhen();

	//println(hasPrefix("hello"));

}

fun testIf(){
	
	var a = 10;
	var b = if(a>10) 11 else 12;
	
	println("b is $b");
}


fun testWhen(){

	var a = 10;
	
	when(a){
		
		10 -> println("a is 10");
		in 1..6 -> println("a is in 1-6");
		in 9..11 -> println("a is in 9..11");
		!in 7..8 -> println("a is not in 7-8");
		in 1 until 10 -> println("a is not in [1,10)");
	}
}


fun hasPrefix(x: Any) = 
	when(x){
		is String -> s.startsWith()
		else -> false
	}






























fun main(args : Array<String>){
	test();

}

fun test(){
	val defferred1 = async(CommonPool){
		"hello1"
	}
	
	val defferred2 = async(UI){
		println("hello2");
		println(defferred1.await());
	}
}







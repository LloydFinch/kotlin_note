

fun main(args: Array<String>){

	println(C().bar());


	testObject();
}


class C {

	private fun foo() = object {

		val x: String = "x";
	}

	fun fii() = object {

		val x: String = "x";
	}

	fun bar(){
		var x1 = foo().x;
		//var x2 = fii().x;
	}
}

object Site {

	var url = "";
	var name = "lloyd's site";

}

fun testObject(){
	var s1 = Site;
	var s2 = Site;

	s1.url = "www.lloyd.finch.com";
	println("s1.url = ${s1.url}");
	println("s2.url = ${s2.url}");
}


























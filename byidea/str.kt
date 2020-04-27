


fun main(args: Array<String>){

	println("hello,world");

	testStr();
}


fun testStr(){

	var str: String ="""
	   |hello,
	   |android!""";
	println("before:$str");
	println("before->size:${str.length}");
	str.trimMargin("|");
	println("after:$str");
	println("after->size:${str.length}");
}
































fun main(args: Array<String>){

	var user = User("lloyd");
	user.test();

}


class User constructor(name: String){

	var thisName = name;	

	init{
		//初始化代码块
		println("init ,name is $name");
	}

	constructor (name: String, age: Int):this(name){

	}

	fun test(){
		println("name is $thisName");
	}
}

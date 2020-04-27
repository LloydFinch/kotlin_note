

fun main(args: Array<String>){

	val firstName = "lloyd";
	val secondName = "finch";
	
	println("my name is ${getName(firstName,secondName)}");

}

fun getName(firstName: String? = "unkown", secondName: String? = "unkown"): String {
	if (hasEmpty(firstName,secondName)) {
		secondName?.let{return@getName "${checkName(firstName)} $secondName"};
		firstName?.let{return@getName "$firstName ${checkName(secondName)}"};
	}
	
	return "$firstName $secondName"
}

fun hasEmpty(vararg strArray: String?): Boolean {
	for (str in strArray){
		str ?:return true;
	}
	return false;
}

fun checkName(name: String?): String = name?:"unkown";












































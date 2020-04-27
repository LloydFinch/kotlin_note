
import kotlin.properties.Delegates

fun main(args: Array<String>){

	val user = User();
	user.name = "first";
	user.name = "second";

}

class User{

	var name: String by Delegates.observable("initial"){

		prop,old,new -> println("$prop, $old, $new");
	}
}



























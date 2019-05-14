
fun main(args: Array<String>){

	var b = A(10);
	B(b).show();

}

interface Base{
	fun show();
}


class A(val x: Int) : Base{

	override fun show(){
		println("value is $x");
	}
}


class B(b: Base) : Base by b









































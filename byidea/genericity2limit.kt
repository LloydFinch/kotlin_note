


fun main(args: Array<String>){

	sort(listOf(1,2,3,4,5));
	//println(cloneWhenGreater(listOf(2,3,4,6,7,9,10),5));
	
	//traverslaList(listOf(1,2,3,4,5,6));
}


//state a limit genericity function
fun <T: Comparable<T>> sort(list: List<T>){
	for(t in list){
		print("$t、");
	}
		
	println();
}

//state a multi limit genericity function 
//fun <T> cloneWhenGreater(list: List<T>, threshold: T): List<T> where T : Comparable, 
//Cloneable {
//	return list.filter(it > threshold).map(it.clone);
//}


//traversal a list
//fun <T> traversalList(list: List<T>){
//	var newList = list.filter(it > 0);

//	println(newList);
//}

























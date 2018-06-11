package adapter_strategy

//所需要的目标对象
data class Target(var id: String) {
    lateinit var userName: String;
    lateinit var userSex: String;

    fun sayHello() {
        println("$userName say hello, my sex is $userSex");
    }
}
package adapter_strategy

//被转换者
data class Adoptee(var id: String) {
    lateinit var name: String;
    lateinit var sex: String;
}
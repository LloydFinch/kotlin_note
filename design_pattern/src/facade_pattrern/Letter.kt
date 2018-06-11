package facade_pattrern

//装在门面内部的底层逻辑
data class Letter(var content: String, var address: String) : ILetter {

    override fun writeContent(content: String) {
        println("write content:$content")
    }

    override fun writeAddress(address: String) {
        println("write address:$address")
    }

    override fun send() {
        println("send letter to $address")
    }


}
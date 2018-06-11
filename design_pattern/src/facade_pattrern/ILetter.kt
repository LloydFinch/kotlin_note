package facade_pattrern

interface ILetter {

    fun writeContent(content: String)

    fun writeAddress(address: String)

    fun send()
}
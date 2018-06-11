package facade_pattrern

class Facade {
    //门面提供给外部的公开方法
    fun sendLetter(address: String, content: String) {

        //门面内部自己进行一系列操作,高层不可见
        var letter: ILetter = Letter(content, address)
        letter.writeContent(content)
        letter.writeAddress(address)
        letter.send()
    }
}
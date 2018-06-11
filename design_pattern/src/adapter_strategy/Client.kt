package adapter_strategy

fun main(args: Array<String>) {
    //1 生成现有类
    var adoptee = Adoptee("10010")
    adoptee.name = "jack"
    adoptee.sex = "man"
    //2 转换成目标类
    var target = Adapter.transferAdopteeToTarget(adoptee);

    //3 使用目标类
    target.sayHello();
}
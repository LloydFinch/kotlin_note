package strategy_pattern

fun main(args: Array<String>) {

    //生成三个锦囊
    var backDoor = Context(BackDoor());
    var greenLight = Context(GivenGreenLight());
    var blockEnemy = Context(BlockEnemy());

    //一次执行
    backDoor.operate()
    greenLight.operate()
    blockEnemy.operate()
}
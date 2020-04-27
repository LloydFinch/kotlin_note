package strategy_pattern

class BackDoor : IStrategy {
    override fun operate() {
        println("执行锦囊妙计->走后门!")
    }
}
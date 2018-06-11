package strategy_pattern

class BlockEnemy : IStrategy {
    override fun operate() {
        println("执行锦囊妙计->断后!");
    }
}
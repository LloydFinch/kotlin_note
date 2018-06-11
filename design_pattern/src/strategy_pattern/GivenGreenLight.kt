package strategy_pattern

class GivenGreenLight : IStrategy {
    override fun operate() {
        println("执行锦囊妙计->开绿灯!")
    }

}
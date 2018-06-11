package strategy_pattern

//锦囊实体
class Context(strategy: IStrategy) {

    //妙计私有化，对外不可见，只知道执行结果
    private var strategy = strategy;

    //锦囊的执行方法
    fun operate() {
        strategy.operate();
    }
}
package adapter_strategy

class Adapter {

    //适配器的转换方法
    companion object {
        fun transferAdopteeToTarget(adoptee: Adoptee): Target {
            var target = Target(adoptee.id)
            target.userName = adoptee.name
            target.userSex = adoptee.sex
            return target
        }
    }
}
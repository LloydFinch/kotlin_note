package structure.mvp

interface LoginPresenter {

    fun verifyNameAndPassword(name: String, password: String)

    fun onDestroy()

}
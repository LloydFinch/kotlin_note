package structure.mvp

class LoginViewImpl : LoginView {

    private var loginPresenter: LoginPresenter = LoginPresenterImpl(this)

    override fun showLoading() {
        println("loading...")
    }

    override fun hideLoading() {
        println("loading over")
    }

    override fun jump() {
        println("jump to main")
    }


    fun clickToLogin() {
        loginPresenter.verifyNameAndPassword("finch", "12345")
    }
}
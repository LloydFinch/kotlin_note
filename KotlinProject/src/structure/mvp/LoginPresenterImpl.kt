package structure.mvp

class LoginPresenterImpl(loginView: LoginView) : LoginPresenter, OnLoginFinishListener {


    private val loginView = loginView
    private var loginModel = LoginModelImpl(this)

    override fun verifyNameAndPassword(name: String, password: String) {

        loginView.showLoading()
        loginModel.login(name, password)
    }

    override fun onDestroy() {

    }

    override fun onSuccess() {
        loginView.hideLoading()
        loginView.jump()
    }

    override fun onFailure() {
        loginView.hideLoading()
    }

    override fun onError(cause: String?) {
        loginView.hideLoading()
    }
}
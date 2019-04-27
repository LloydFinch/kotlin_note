package structure.mvp

class LoginModelImpl(onLoginFinishListener: OnLoginFinishListener) : LoginModel {

    private val onLoginFinishListener = onLoginFinishListener

    override fun login(name: String, password: String) {

        try {
            if ("finch" == name && "12345" == password) {
                onLoginFinishListener.onSuccess()
            } else {
                onLoginFinishListener.onFailure()
            }
        } catch (e: Exception) {
            onLoginFinishListener.onError(e.message)
        }
    }
}
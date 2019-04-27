package structure.mvp

interface OnLoginFinishListener {

    fun onSuccess()

    fun onFailure()

    fun onError(cause: String?)

}
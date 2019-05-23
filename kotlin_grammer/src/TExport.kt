class TExport {
    companion object {
        fun combineToString(a: Int, b: Int, action: (Int) -> (Int) -> String): String {

            return action.invoke(a).invoke(b)
        }
    }
}
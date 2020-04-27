package coroutines.samplejvm

import Looger
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


suspend fun main() {

    GlobalScope.launch {
        Looger.debug("1")
        delay(1000)
        Looger.debug("2")
    }.join()

}

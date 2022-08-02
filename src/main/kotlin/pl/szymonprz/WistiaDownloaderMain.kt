package pl.szymonprz

import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain

@QuarkusMain
class WistiaDownloaderMain: QuarkusApplication {
    override fun run(vararg args: String?): Int {
        println("hello worl 23d")
        return 0
    }
}
package pl.szymonprz.infrastructure

import java.io.InputStream
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class FileDownloader {

    fun downloadFileToDisk(url: URL, filename: String) {
        val inputStream: InputStream = url.openStream()
        Files.copy(inputStream, Paths.get(filename), StandardCopyOption.REPLACE_EXISTING)
    }
}
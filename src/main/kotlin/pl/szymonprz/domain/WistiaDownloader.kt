package pl.szymonprz.domain

import pl.szymonprz.infrastructure.FileDownloader
import java.net.URL
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class WistiaDownloader {

    @Inject
    private lateinit var wistiaVideoUrlsLoader: WistiaVideoUrlsLoader

    @Inject
    private lateinit var fileDownloader: FileDownloader

    fun download(wistiaVideoCode: String, outputFilePath: String) {
        val videoUrls = wistiaVideoUrlsLoader.loadVideoUrls(wistiaVideoCode)
        val selectedVideo = videoUrls.find { videoUrl -> videoUrl.hasLabel("1080p") }
        if (selectedVideo == null) {
            println("not found 1080p video, download stopped")
            return
        }
        val url = URL(selectedVideo.url)
        println("[started] Downloading video: $url")
        fileDownloader.downloadFileToDisk(url, outputFilePath)
        println("[finished] downloaded video: $url")
    }

}
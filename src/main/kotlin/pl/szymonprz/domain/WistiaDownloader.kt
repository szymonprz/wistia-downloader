package pl.szymonprz.domain

import mu.KotlinLogging
import pl.szymonprz.infrastructure.FileDownloader
import java.net.URL
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

private val logger = KotlinLogging.logger {}

@ApplicationScoped
class WistiaDownloader {

    @Inject
    private lateinit var wistiaVideoUrlsLoader: WistiaVideoUrlsLoader

    @Inject
    private lateinit var fileDownloader: FileDownloader

    fun download(wistiaVideoCode: String, resolution: String, outputFilePath: String) {
        val videoUrls = wistiaVideoUrlsLoader.loadVideoUrls(wistiaVideoCode)
        val selectedVideo = videoUrls.find { videoUrl -> videoUrl.hasResolution(resolution) }
        if (selectedVideo == null) {
            logger.error { "$resolution video not found, download stopped, try different options with -r flag" }
            return
        }
        val url = URL(selectedVideo.url)
        logger.info { "[started] Downloading video: $url" }
        fileDownloader.downloadFileToDisk(url, outputFilePath)
        logger.info { "[finished] Downloading video: $url" }
    }

}
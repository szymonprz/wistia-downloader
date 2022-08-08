package pl.szymonprz.command

import picocli.CommandLine
import pl.szymonprz.domain.WistiaCodeExtractor
import pl.szymonprz.domain.WistiaDownloader
import javax.inject.Inject

@CommandLine.Command
class WistiaDownloaderCommand : Runnable {

    @CommandLine.Option(
        names = ["-l", "--link-and-thumbnail"],
        description = ["Link and thumbnail copied with right click of mouse from wistia video"]
    )
    private var linkAndThumbnail: String? = null

    @CommandLine.Option(
        names = ["-v", "--video-code"],
        description = ["Wistia video code"]
    )
    private var videoCode: String? = null

    @CommandLine.Option(
        names = ["-o", "--output-file"],
        description = ["Output file path"],
        required = true
    )
    private lateinit var outputFilePath: String

    @Inject
    private lateinit var wistiaDownloader: WistiaDownloader

    @Inject
    private lateinit var wistiaCodeExtractor: WistiaCodeExtractor

    override fun run() {
        videoCode?.let {
            wistiaDownloader.download(it, outputFilePath)
        } ?: linkAndThumbnail?.let {
            wistiaCodeExtractor.extract(it)
        }?.also {
            wistiaDownloader.download(it, outputFilePath)
        } ?: println("missing parameters")
    }
}
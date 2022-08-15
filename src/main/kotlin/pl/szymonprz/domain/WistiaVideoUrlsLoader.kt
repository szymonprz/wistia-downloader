package pl.szymonprz.domain


interface WistiaVideoUrlsLoader {
    fun loadVideoUrls(videoCode: String): List<VideoUrl>
}

data class VideoUrl(val resolution: String, val url: String) {
    fun hasResolution(requestedLabel: String): Boolean {
        return resolution == requestedLabel
    }
}

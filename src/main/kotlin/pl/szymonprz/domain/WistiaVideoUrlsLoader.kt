package pl.szymonprz.domain


interface WistiaVideoUrlsLoader {
    fun loadVideoUrls(videoCode: String): List<VideoUrl>
}

data class VideoUrl(val label: String, val url: String) {
    fun hasLabel(requestedLabel: String): Boolean {
        return label == requestedLabel
    }
}

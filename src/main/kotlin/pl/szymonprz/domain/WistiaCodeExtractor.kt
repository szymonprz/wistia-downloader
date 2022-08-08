package pl.szymonprz.domain

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class WistiaCodeExtractor {
    fun extract(linkAndThumbnail: String): String? {
        return linkAndThumbnail.substringAfter("wvideo=", missingDelimiterValue = "")
            .substringBefore("\"", missingDelimiterValue = "")
            .ifEmpty { null }
    }
}
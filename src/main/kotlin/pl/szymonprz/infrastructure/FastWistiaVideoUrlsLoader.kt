package pl.szymonprz.infrastructure

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import org.eclipse.microprofile.rest.client.inject.RestClient
import pl.szymonprz.domain.VideoUrl
import pl.szymonprz.domain.WistiaVideoUrlsLoader
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class FastWistiaVideoUrlsLoader : WistiaVideoUrlsLoader {

    @Inject
    @RestClient
    private lateinit var fastWistiaNetRemoteService: FastWistiaNetRemoteService

    @Inject
    private lateinit var objectMapper: ObjectMapper

    override fun loadVideoUrls(videoCode: String): List<VideoUrl> {
        val videoHtml = fastWistiaNetRemoteService.getFastWistiaVideoHtml(videoCode)
        val assets = videoHtml.substringAfter("W.iframeInit(").substringBefore(", {});")
        val fastWistiaAssets = objectMapper.readValue(assets, FastWistiaAssets::class.java)
        return fastWistiaAssets.assets.map { VideoUrl(it.displayName, it.url) }
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class FastWistiaAssets(val assets: List<AssetResponse>)
data class AssetResponse(@JsonProperty("display_name") val displayName: String, val url: String)
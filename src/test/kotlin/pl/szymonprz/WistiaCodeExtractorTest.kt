package pl.szymonprz

import io.quarkus.test.junit.QuarkusTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import pl.szymonprz.domain.WistiaCodeExtractor
import javax.inject.Inject

@QuarkusTest
class WistiaCodeExtractorTest {
    @Inject
    private lateinit var wistiaCodeExtractor: WistiaCodeExtractor

    @Test
    fun `should extract wistia video code from link and thumbnail`() {
        // given
        val expectedVideoCode = "123456"
        val linkAndThumbnail =
            "<p><a href=\"https://wistia-videos/products/blahblah/categories/123123/posts/1231242?wvideo=$expectedVideoCode\"><img src=\"https://cdn.something.com/images/image.jpg\" width=\"400\" height=\"225\" style=\"width: 400px; height: 225px;\"></a></p><p><a href=\"https://something.com/products/something/categories/1231231/posts/1231231?wvideo=$expectedVideoCode\">Wideo name</a></p>"

        // when
        val videoCode = wistiaCodeExtractor.extract(linkAndThumbnail)

        // then
        assertThat(videoCode).isEqualTo(expectedVideoCode)
    }
}
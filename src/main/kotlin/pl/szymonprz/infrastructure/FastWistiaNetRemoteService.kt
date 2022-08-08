package pl.szymonprz.infrastructure

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.QueryParam

@RegisterRestClient(baseUri = "https://fast.wistia.net/embed/iframe")
interface FastWistiaNetRemoteService {

    @GET
    @Path("/{videoCode}")
    fun getFastWistiaVideoHtml(
        @PathParam("videoCode") videoCode: String,
        @QueryParam("videoFoam") videoFoam: Boolean = true
    ): String
}
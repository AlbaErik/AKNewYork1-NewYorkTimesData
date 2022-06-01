package ayds.ak1.newyorktimes.article.external.infos

import ayds.ak1.newyorktimes.article.external.NYArticle
import ayds.ak1.newyorktimes.article.external.NYInfoService
import retrofit2.Response

internal class NYInfoServiceImpl(
    private val nyTimesAPI: NYTimesAPI,
    private val nyTimesToInfoResolver: NYTimesToInfoResolver,
) : NYInfoService {


    override fun getArtistInfo(artistName: String): NYArticle? {
        val callResponse = getArtistInfoFromService(artistName)
        return nyTimesToInfoResolver.getArtistInfoFromExternalData(callResponse.body(), artistName)
    }

    private fun getArtistInfoFromService(query: String): Response<String> {
        return nyTimesAPI.getArtistInfo(query).execute()
    }
}

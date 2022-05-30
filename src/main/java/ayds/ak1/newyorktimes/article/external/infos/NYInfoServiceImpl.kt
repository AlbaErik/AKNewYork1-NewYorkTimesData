package ayds.ak1.newyorktimes.article.external.infos

import ayds.ak1.newyorktimes.article.external.NYInfoService
import ayds.ak1.newyorktimes.article.external.NYArticleCard
import retrofit2.Response

internal class NYInfoServiceImpl(
    private val nyTimesAPI: NYTimesAPI,
    private val nyTimesToInfoResolver: NYTimesToInfoResolver,
) : NYInfoService {


    override fun getArtistInfo(artistName: String): NYArticleCard? {
        val callResponse = getArtistInfoFromService(artistName)
        return nyTimesToInfoResolver.getArtistInfoFromExternalData(callResponse.body(), artistName)
    }

    private fun getArtistInfoFromService(query: String): Response<String> {
        return nyTimesAPI.getArtistInfo(query).execute()
    }
}

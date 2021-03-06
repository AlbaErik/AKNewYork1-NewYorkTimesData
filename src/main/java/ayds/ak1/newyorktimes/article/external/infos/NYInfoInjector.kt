package ayds.ak1.newyorktimes.article.external.infos

import ayds.ak1.newyorktimes.article.external.NYInfoService
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object NYInfoInjector {

    private const val BASE_URL = "https://api.nytimes.com/svc/search/v2/"
    private val nyTimesAPIRetrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
    private val nyTimesAPI = nyTimesAPIRetrofit.create(NYTimesAPI::class.java)
    private val nyTimesToInfoResolver: NYTimesToInfoResolver = JsonToInfoResolver()

    val nyInfoService: NYInfoService = NYInfoServiceImpl(
        nyTimesAPI,
        nyTimesToInfoResolver
    )
}
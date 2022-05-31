package ayds.ak1.newyorktimes.article.external.infos

import com.google.gson.Gson
import com.google.gson.JsonObject
import ayds.ak1.newyorktimes.article.external.NYArticle

interface NYTimesToInfoResolver {
    fun getArtistInfoFromExternalData(serviceData: String?, artistName: String): NYArticle?
}

private const val RESPONSE = "response"
private const val DOCS = "docs"
private const val ABSTRACT = "abstract"
private const val WEB_URL = "web_url"
private const val URL_NYTIMES_LOGO="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/NYC_Montage_2014_4_-_Jleon.jpg/456px-NYC_Montage_2014_4_-_Jleon.jpg"

internal class JsonToInfoResolver : NYTimesToInfoResolver {

    override fun getArtistInfoFromExternalData(
        serviceData: String?,
        artistName: String
    ): NYArticle? =
        try {
            serviceData?.getResponse()?.let { item ->
                NYArticle(
                    item.getArtistInformation(),
                    item.getUrl(),
                    artistName,
                    URL_NYTIMES_LOGO
                )
            }
        } catch (e: Exception) {
            null
        }

    private fun String?.getResponse(): JsonObject {
        val infoJson = Gson().fromJson(this, JsonObject::class.java)
        return infoJson[RESPONSE].asJsonObject
    }

    private fun JsonObject.getArtistInformation(): String {
        val abstract = this[DOCS].asJsonArray[0].asJsonObject[ABSTRACT]
        return abstract.asString.replace("\\n", "\n")
    }

    private fun JsonObject.getUrl(): String {
        return this[DOCS].asJsonArray[0].asJsonObject[WEB_URL].asString
    }
}
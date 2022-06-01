package ayds.ak1.newyorktimes.article.external



interface NYInfoService {

    fun getArtistInfo(artistName: String): NYArticle?
}
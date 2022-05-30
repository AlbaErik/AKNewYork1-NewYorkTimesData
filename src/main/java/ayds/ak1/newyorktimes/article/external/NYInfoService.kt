package ayds.ak1.newyorktimes.article.external

import ayds.newyork.songinfo.moredetails.model.entities.NYArticle

interface NYInfoService {

    fun getArtistInfo(artistName: String): NYArticle?
}
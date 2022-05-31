package ayds.ak1.newyorktimes.article.external

interface Card {
    val description: String
    val infoURL: String
    val artistName: String
    val source: String
    var sourceLogoUrl: String
}

data class NYArticleCard(
    override val description: String,
    override val infoURL: String,
    override val artistName:String,
    override val source: String,
    override var sourceLogoUrl: String
) : Card
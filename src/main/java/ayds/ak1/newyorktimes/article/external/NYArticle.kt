package ayds.ak1.newyorktimes.article.external

const val URL_NYTIMES_LOGO =
    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/NYC_Montage_2014_4_-_Jleon.jpg/456px-NYC_Montage_2014_4_-_Jleon.jpg"

data class NYArticle(
    val description: String,
    val infoURL: String,
    val artistName: String,
    val logoURL: String
)
package ayds.ak1.newyorktimes.article.external

const val URL_NYTIMES_LOGO =
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVioI832nuYIXqzySD8cOXRZEcdlAj3KfxA62UEC4FhrHVe0f7oZXp3_mSFG7nIcUKhg&usqp=CAU"

data class NYArticle(
    val description: String,
    val infoURL: String,
    val artistName: String,
    val logoURL: String
)
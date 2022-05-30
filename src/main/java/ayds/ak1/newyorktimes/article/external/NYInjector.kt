package ayds.ak1.newyorktimes.article.external

import ayds.ak1.newyorktimes.article.external.infos.*

object NYInjector {
    val nyInfoService: NYInfoService = NYInfoInjector.nyInfoService
}


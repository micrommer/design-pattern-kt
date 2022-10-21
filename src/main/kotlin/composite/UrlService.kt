package composite

import java.net.URL

/**
 * This class represent the Leaf, the simple component of our app.
 */
class UrlService : ManageableComponent {
    private val inputQueryList = mutableListOf<URL>()
    override fun clearResource() = inputQueryList.clear()

    override fun resourceSize() = inputQueryList.distinctBy {
        it.port
    }.size

    fun addUrl(query: URL) = inputQueryList.add(query)
}
package composite

/**
 * This class represent the Leaf, the simple component of our app.
 */
class QueryService : ManageableComponent {
    private val inputQueryList = mutableListOf<String>()
    override fun clearResource() = inputQueryList.clear()

    override fun resourceSize() = inputQueryList.size

    fun addQuery(query: String) = inputQueryList.add(query)
}
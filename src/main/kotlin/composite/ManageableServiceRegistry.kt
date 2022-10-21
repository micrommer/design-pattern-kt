package composite

/**
 * This class acts as a container in our app, it could have leaves and also acts as a component.
 */
class ManageableServiceRegistry : ManageableComponent {
    private val children: MutableCollection<ManageableComponent> = arrayListOf()
    private var allocatedServiceSpace: Int = 0

    fun add(component: ManageableComponent) = children.add(component)

    fun remove(component: ManageableComponent) = children.remove(component)

    fun getAll() = children

    override fun clearResource() = children.forEach { it.clearResource() }.also { flush() }

    override fun resourceSize() = children.sumOf { it.resourceSize() } + allocatedServiceSpace

    fun allocateMore() {
        allocatedServiceSpace += 1024
    }

    private fun flush() {
        allocatedServiceSpace = 0
    }
}
package composite

/**
 * The interface represents all the functionality that are common between all leaves in the app tree.
 * Simples or containers doesn't matter.
 */
interface ManageableComponent {
    fun clearResource()
    fun resourceSize(): Int
}
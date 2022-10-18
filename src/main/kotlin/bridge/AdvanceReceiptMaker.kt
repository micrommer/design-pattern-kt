package bridge

/**
 * Refined abstraction that likes its parent work with implementation and has some extra functionality
 */
class AdvanceReceiptMaker(private val templateEngine: TemplateEngine) : ReceiptMaker(templateEngine) {
    fun createReceipt(title: String, vararg items : Pair<String, Double>): String {
        val builder = StringBuilder().append(templateEngine.setTitle(title))
        items.forEach {
            builder.append("\n")
            builder.append(templateEngine.setItem(it.first))
            builder.append(templateEngine.setPrice(it.second))
            builder.append("\n")
        }
        return builder.toString()
    }
}
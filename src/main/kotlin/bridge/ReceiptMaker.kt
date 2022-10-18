package bridge

/**
 * This class acts as abstraction concept in `Bridge` design pattern. it interacts with implementation interface and contains
 * Logic.
 */
open class ReceiptMaker(private val templateEngine: TemplateEngine) {
    fun createReceipt(title: String, item: String, price: Double) = StringBuilder()
        .append(templateEngine.setTitle(title))
        .append(templateEngine.setItem(item))
        .append(templateEngine.setPrice(price))
        .toString()
}
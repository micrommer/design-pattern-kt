package bridge

/**
 * The client only works with `Abstraction` but it needs to declare the impl to work with
 */
fun main() {
    val receiptMaker = ReceiptMaker(HtmlTemplateEngine())
    println(receiptMaker.createReceipt("Big Bang Store", "Planet A", 2.3))

    val advanceReceiptMaker = AdvanceReceiptMaker(MarkDownTemplateEngine())
    println(advanceReceiptMaker.createReceipt("Sushi Restaurant",
        Pair("Main Sushi", 2.4),
        Pair("Salad", 1.4),
        Pair("Water", .7),
    ))
}
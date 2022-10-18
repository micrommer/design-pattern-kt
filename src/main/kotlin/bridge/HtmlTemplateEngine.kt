package bridge

class HtmlTemplateEngine : TemplateEngine {
    override fun setTitle(title: String) = "<h1>$title</h1>"

    override fun setItem(item: String) = "<h3>$item</h3>"

    override fun setPrice(price: Double) = ":<h3>[$price]</h3>"
}
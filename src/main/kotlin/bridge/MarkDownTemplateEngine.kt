package bridge

class MarkDownTemplateEngine : TemplateEngine {
    override fun setTitle(title: String) = "# $title "

    override fun setItem(item: String) = "### $item "

    override fun setPrice(price: Double) = "### : *$price* ###"
}
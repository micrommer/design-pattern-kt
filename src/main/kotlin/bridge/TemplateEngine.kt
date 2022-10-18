package bridge

/**
 * This class acts as `Implementation` part of `Bridge` design pattern.
 */
interface TemplateEngine {
    fun setTitle(title: String): String
    fun setItem(item: String): String
    fun setPrice(price: Double): String
}
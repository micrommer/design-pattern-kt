package decorator

/**
 * Common interface between BaseDecorator and ConcreteComponent in decorator design pattern.
 */
interface RequestFilter {
    fun chain(req: Request) : Request
}


data class Request(
    val body: String,
    val headers: MutableMap<String, String> = mutableMapOf(),
    val url: String
)
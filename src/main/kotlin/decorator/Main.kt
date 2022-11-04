package decorator

fun main() {
    val request = Request(
        "{}", mutableMapOf(
            Pair("accept-encoding", "tar"), Pair("content-type", "application/json")
        ), "google.com"
    )
    val securityChain = SecurityChain()
    val interceptRequestFilterDecorator = InterceptRequestFilterDecorator(securityChain)
    val headerReducerRequestFilterDecorator = HeaderReducerRequestFilterDecorator(interceptRequestFilterDecorator)
    val urlNormalizerRequestFilterDecorator = UrlNormalizerRequestFilterDecorator(headerReducerRequestFilterDecorator)
    val interceptRequestFilterDecorator2 = InterceptRequestFilterDecorator(urlNormalizerRequestFilterDecorator)
    interceptRequestFilterDecorator2.chain(request)
}
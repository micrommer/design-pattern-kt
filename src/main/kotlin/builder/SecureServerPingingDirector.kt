package builder

class SecureServerPingingDirector(private val reqBuilder: ReqBuilder) {
    fun make(): ReqBuilder {
        reqBuilder.reset()
        reqBuilder.setBody("hello secure server")
        reqBuilder.setHeader(hashMapOf(Pair("authorization", "1232aA"), Pair("host", "twitter.com")))
        reqBuilder.setPath("https://google.com")
        reqBuilder.setEncoder {
            "body : $it"
        }
        return reqBuilder
    }
}
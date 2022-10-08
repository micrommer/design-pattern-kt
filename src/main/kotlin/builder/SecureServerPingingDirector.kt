package builder

class SecureServerPingingDirector(private val reqBuilder: ReqBuilder) {
    fun make(): ReqBuilder {
        reqBuilder.reset()
        reqBuilder.setHttpVerb("POST")
        reqBuilder.setBody("hello secure server")
        reqBuilder.setHeader(
            hashMapOf(
                Pair("authorization", "1232aA"),
                Pair("host", "twitter.com"),
                Pair("Accept-Encoding", "BASE64")
            )
        )
        reqBuilder.setPath("https://google.com")
        reqBuilder.setEncoder {
            "body : $it"
        }
        return reqBuilder
    }
}
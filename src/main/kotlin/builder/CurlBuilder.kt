package builder

class CurlBuilder : ReqBuilder {
    var curlCommand = "curl -X %VERB% -p %PATH% -b {%BODY%} -h {%HEADER%}"
    var reqBody: Any? = null
    var encoderFunction: ((Any) -> String)? = null
    override fun setHttpVerb(verb: String) {
        curlCommand = curlCommand.replace("%VERB%", verb.uppercase())
    }

    override fun setPath(path: String) {
        curlCommand = curlCommand.replace("%PATH%", path)
    }

    override fun setHeader(headers: HashMap<String, String>) {
        curlCommand = curlCommand.replace("%HEADER%", headers.map {
            "${it.key} : ${it.value}"
        }.joinToString(separator = ","))
    }

    override fun setBody(any: Any) {
        reqBody = any
    }

    override fun setEncoder(encoder: (obj: Any) -> String) {
        encoderFunction = encoder
    }

    override fun reset() {
        curlCommand = "curl -X %VERB% -p %PATH% -b {%BODY%} -h {%HEADER%}"
    }

    fun getResult(): String {
        reqBody?.let {
            encoderFunction?.invoke(it) ?: it.toString()
        }?.let {
            curlCommand = curlCommand.replace("%BODY%", it)
        }
        return curlCommand.replace(regex = Regex("%.*?%"), replacement = "")
    }
}
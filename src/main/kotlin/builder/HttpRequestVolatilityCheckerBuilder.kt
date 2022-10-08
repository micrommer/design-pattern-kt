package builder

/**
 * Another impl of ReqBuilder to show different product and different approach but same builder interface usage
 */
class HttpRequestVolatilityCheckerBuilder : ReqBuilder {
    private var score: Int = 0
    private var steps = 0

    override fun setHttpVerb(verb: String) {
        steps += 1
        when (verb) {
            "POST" -> score += 10
            "PUT" -> score += 10
            "GET" -> score += 5
            "PATCH" -> score += 10
            else -> score += 2
        }
    }

    override fun setPath(path: String) {
        steps += 1
        when {
            path.startsWith("https") -> score += 10
            else -> score += 2
        }
    }

    override fun setHeader(headers: HashMap<String, String>) {
        steps += 1
        when {
            headers.containsKey("Cookie") -> score += 1
            headers.containsKey("Accept-Encoding") -> score += 4
            headers.containsKey("Cache-Control") -> score += 1
            else -> score += 10
        }
    }

    // Doesn't matter in scoring system
    override fun setBody(any: Any) {}
    override fun setEncoder(encoder: (obj: Any) -> String) {}

    override fun reset() {
        score = 0
        steps = 0
    }

    fun getResult() = (if (steps > 0) score / steps else 0).toString() + " of 10"
}
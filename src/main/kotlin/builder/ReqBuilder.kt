package builder

/**
 * Builder interface to declare available step to build an object.
 */
interface ReqBuilder {
    fun setHttpVerb(verb: String)
    fun setPath(path: String)
    fun setHeader(headers: HashMap<String, String>)
    fun setBody(any: Any)
    fun setEncoder(encoder: (obj: Any) -> String)
    fun reset()
}
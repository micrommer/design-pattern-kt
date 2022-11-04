package decorator

/**
 * Concrete impl of the RequestFilter, this is actually the primary component.
 */
class SecurityChain : RequestFilter {
    override fun chain(req: Request) : Request {
        return req.copy(
            headers = req.headers.apply {
                put("Secured", "true")
            }
        )
    }
}
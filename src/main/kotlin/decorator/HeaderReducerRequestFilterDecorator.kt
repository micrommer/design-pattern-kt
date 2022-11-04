package decorator

class HeaderReducerRequestFilterDecorator(override val requestFilter: RequestFilter) : RequestFilterDecorator(requestFilter) {
    override fun chain(req: Request): Request {
        return requestFilter.chain(req.copy(
            headers = req.headers.apply {
                remove("content-type")
                remove("content-length")
                remove("agent")
            }
        ))
    }
}
package decorator

/**
 * Base decorator to define optional actions that are possible to done with primary FilterRequest
 */
open class RequestFilterDecorator(open val requestFilter: RequestFilter) : RequestFilter {
    override fun chain(req: Request): Request {
        return requestFilter.chain(req)
    }
}
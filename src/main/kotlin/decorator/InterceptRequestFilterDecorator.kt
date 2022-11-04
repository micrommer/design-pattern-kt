package decorator

class InterceptRequestFilterDecorator(override val requestFilter: RequestFilter) : RequestFilterDecorator(requestFilter) {
    override fun chain(req: Request): Request {
        println("---------------------Intercept---------------------")
        println(req.body)
        println(req.headers)
        println(req.url)
        println("---------------------Intercept---------------------")
        return requestFilter.chain(req)
    }
}
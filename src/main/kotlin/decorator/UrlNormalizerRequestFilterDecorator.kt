package decorator

class UrlNormalizerRequestFilterDecorator(override val requestFilter: RequestFilter) : RequestFilterDecorator(requestFilter) {
    override fun chain(req: Request): Request {
        return requestFilter.chain(req.copy(
            url = StringBuilder().append("https://www.").append(req.url).toString()
        ))
    }
}
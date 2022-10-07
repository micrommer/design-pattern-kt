package abstractfactory

const val prefix = "TAR"

/**
 * The actual abstract factory, all implementations will contain the own products but everything is same and depends on
 * Product interface in the client perspective
 */
class TarFactory : ZipFactory {
    override fun getWriter() = TarWriter()
    override fun getReader() = TarReader()
}

//Products interfaces to expose to the client
class TarReader : ZipReader {
    override fun read(byteArray: ByteArray) = byteArray.decodeToString().removePrefix(prefix)
}

class TarWriter : ZipWriter {
    override fun write(str: String) = (prefix + str).toByteArray()
}
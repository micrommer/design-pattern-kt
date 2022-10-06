package abstractfactory

/**
 * The actual abstract factory, all implementations will contain the own products but everything is same and depends on
 * Product interface in the client perspective
 */
class RarFactory : ZipFactory {
    override fun getWriter() = RarWriter()
    override fun getReader() = RarReader()
}

/**
 * Products interfaces to expose to the client
 */
class RarReader : ZipReader {
    override fun read(byteArray: ByteArray) = byteArray.decodeToString()
}

class RarWriter : ZipWriter {
    override fun write(str: String) = str.encodeToByteArray()
}
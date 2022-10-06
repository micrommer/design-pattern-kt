package abstractfactory

const val prefix = "TAR"

class TarFactory : ZipFactory {
    override fun getWriter() = TarWriter()
    override fun getReader() = TarReader()
}

class TarReader : ZipReader {
    override fun read(byteArray: ByteArray) = byteArray.decodeToString().removePrefix(prefix)
}

class TarWriter : ZipWriter {
    override fun write(str: String) = (prefix + str).toByteArray()
}
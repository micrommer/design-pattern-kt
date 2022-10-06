package abstractfactory

interface ZipFactory {
    fun getWriter(): ZipWriter
    fun getReader(): ZipReader
}

interface ZipReader {
    fun read(byteArray: ByteArray): String
}

interface ZipWriter {
    fun write(str: String): ByteArray
}
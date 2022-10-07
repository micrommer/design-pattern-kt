package abstractfactory

/**
 * Abstract factory interface.
 * Works with abstract product.
 */
interface ZipFactory {
    fun getWriter(): ZipWriter
    fun getReader(): ZipReader
}

// Abstract products
interface ZipReader {
    fun read(byteArray: ByteArray): String
}

interface ZipWriter {
    fun write(str: String): ByteArray
}
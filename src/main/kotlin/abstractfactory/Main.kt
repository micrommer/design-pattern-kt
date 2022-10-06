package abstractfactory

fun main() {
    val basis = "This is a health checking op!"
    val classPathZipClient = "7zip"
    when (classPathZipClient) {
        "WinRar" -> {
            Main(RarFactory())
        }
        "7zip" -> {
            Main(TarFactory())
        }
        else -> {
            throw NotImplementedError()
        }
    }.check(basis)
}


class Main(private val zipper: ZipFactory) {
    fun check(str: String) {
        val zipped = zipper.getWriter().write(str)
        println("Zipped file size is ${zipped.size}")
        val unzipped = zipper.getReader().read(zipped)
        println("unzipped value is '$unzipped'")
    }
}
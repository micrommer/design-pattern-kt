package adapter

fun main() {
    var fileLoggingAdapter : FileLoggingAdapter = NioLoggingAdapter()
    fileLoggingAdapter.enableTimeAppendix(true)
    val nioResult = fileLoggingAdapter.write("Application started successfully")
    println(nioResult)

    //------------------------------------------------------------------

    fileLoggingAdapter = IoLoggingAdapter()
    val ioResult = fileLoggingAdapter.write("Application Exist with 0")
    println(ioResult)
}
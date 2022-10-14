package adapter

fun main() {
    val fileLoggingAdapter = NioLoggingAdapter()
    fileLoggingAdapter.enableTimeAppendix(true)
    val result = fileLoggingAdapter.write("Application started successfully")
    println(result)
}
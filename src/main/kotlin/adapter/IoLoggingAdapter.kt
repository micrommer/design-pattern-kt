package adapter

import java.io.File
import java.io.FileWriter
import java.nio.charset.Charset
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Here we have IO package as the incompatible service, and we want to adapt it with our requirements.
 */
class IoLoggingAdapter : FileLoggingAdapter {
    private var timeAppendix: Boolean? = null
    private val formatLog = { str: String ->
        val log = if (timeAppendix == true) "${LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)} : $str" else str
        "$log\n"
    }

    override fun write(str: String): Boolean {
        return try {
            val file = File("log.txt")
            if (!file.exists()) file.createNewFile()
            val writer = FileWriter(file, Charset.defaultCharset(),true)
            writer.write(formatLog(str))
            writer.flush()
            true
        } catch (e: Exception) {
            e.stackTrace
            false
        }
    }

    override fun enableTimeAppendix(enable: Boolean) {
        timeAppendix = enable
    }
}
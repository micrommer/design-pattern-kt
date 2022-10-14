package adapter

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.io.path.exists

/**
 * Here we have NIO package as the incompatible service, and we want to adapt it.
 */
class NioLoggingAdapter : FileLoggingAdapter {
    private var timeAppendix = false
    private val formatLog = { str: String ->
        val log = if (timeAppendix) "${LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)} : $str" else str
        (log + "\n").encodeToByteArray()
    }

    override fun write(str: String): Boolean {
        return try {
            val logPath = Path.of("log.txt")
            if (!logPath.exists()) Files.createFile(logPath)
            Files.write(logPath, formatLog(str), StandardOpenOption.APPEND)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override fun enableTimeAppendix(enable: Boolean) {
        timeAppendix = enable
    }
}
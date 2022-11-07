package facade

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Logging {
    fun log(str: String) {
        println("${LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME)} : $str")
    }
}
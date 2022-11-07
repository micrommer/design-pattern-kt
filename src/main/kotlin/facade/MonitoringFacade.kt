package facade

import java.nio.file.StandardOpenOption
import kotlin.io.path.readLines
import kotlin.io.path.writeLines

/**
 * The Facade encapsulate internal complexity and expose tidy functions to use by client without trouble.
 * It could be used by client or another facade.
 */
class MonitoringFacade {
    private val filingFacade = FilingFacade()
    private val logger = Logging()
    private val formatter = MonitoringValueFormatter()

    /**
     * Increases counter of a specific id
     */
    fun count(id: String) {
        var found = false
        val lines = filingFacade.getPath().readLines()
            .map {
                formatter.extract(id, it)
                    ?.let { str ->
                        found = true
                        return@map formatter.format(id, (str.trim().toInt() + 1).toString())
                    }
                return@map it
            }.toMutableList()
        if (!found)
            lines.add(formatter.format(id, "1"))
        filingFacade.getPath().writeLines(lines, options = arrayOf(StandardOpenOption.WRITE))
        logger.log("Count increased for $id")
    }

    /**
     * Records the execution time of a function
     */
    fun time(id: String, func: () -> Unit) {
        val start = System.currentTimeMillis()
        func()
        val time = System.currentTimeMillis() - start
        filingFacade.getPath().writeLines(
            arrayListOf(formatter.format(id, time.toString())),
            options = arrayOf(StandardOpenOption.APPEND)
        )
        logger.log("Time measured for $id is ${time}ms")
    }
}
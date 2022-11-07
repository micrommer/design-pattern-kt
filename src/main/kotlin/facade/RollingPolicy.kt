package facade

import java.nio.file.Files
import java.nio.file.Path
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.io.path.name

class RollingPolicy {
    private val fileNameTemplate = "monitoring:^.txt"
    fun getPolicy(currentFile: Path?): Policy {
        val currentDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)
        return if (!currentDate.equals(currentFile?.name?.split(":")?.get(1) ?: "")) {
            Policy(true, createNewFile(fileNameTemplate.replace("^", currentDate)))
        } else {
            Policy(false, null)
        }
    }

    private fun createNewFile(name: String): Path {
        val path = Path.of(name)
        val exist = Files.exists(path)
        if (!exist)
            Files.createFile(path)
        return path
    }
}

data class Policy(val newFileRequired: Boolean, val newFileName: Path?)
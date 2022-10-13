package singleton

import java.nio.file.Path

/**
 * Singleton implementation of a simple directory manager. The singleton design resolve 2 problem here, first, keep a single
 * source of truth in whole application, second, create global access across whole application.
 * Java Liked impl.
 */
class SystemDirManager private constructor() {
    companion object {
        private var instance: SystemDirManager? = null
        fun getInstance() = instance ?: SystemDirManager().apply {
            instance = this
        }
    }

    private val dirs = mutableListOf<Path>()

    fun getAll(): MutableList<Path> {
        return dirs
    }

    fun create(directoryPath: String) {
        val path = Path.of(directoryPath)
        if (dirs.contains(path)) throw IllegalStateException()
        dirs.add(path)
    }
}

object SystemDirManagerKt {
    private val dirs = mutableListOf<Path>()

    fun getAll(): MutableList<Path> {
        return dirs
    }

    fun create(directoryPath: String) {
        val path = Path.of(directoryPath)
        if (dirs.contains(path)) throw IllegalStateException()
        dirs.add(path)
    }
}
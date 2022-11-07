package facade

import java.nio.file.Path

/**
 * The Facade encapsulate internal complexity and expose tidy functions to use by client without trouble.
 * It could be used by client or another facade.
 */

class FilingFacade {
    enum class Profile {
        DEVELOPMENT, PRODUCTION
    }

    private val profile = Profile.DEVELOPMENT
    private val rollingPolicy = RollingPolicy()

    object PathStorage {
        var path: Path? = null
    }

    fun getPath(): Path {
        return when (profile) {
            Profile.DEVELOPMENT -> {
                rollingPolicy.getPolicy(PathStorage.path).let {
                    if (it.newFileRequired) {
                        PathStorage.path = it.newFileName!!
                    }
                    PathStorage.path!!
                }
            }
            Profile.PRODUCTION -> {
                throw NotImplementedError()
            }
        }
    }
}
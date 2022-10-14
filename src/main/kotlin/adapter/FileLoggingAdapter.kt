package adapter

/**
 * We have a service (filing service) that doesn't work exactly as we wish, we need its functionality but a little different.
 * We need to declare how to interact with  the (file service) as an interface.
 */

interface FileLoggingAdapter {
    fun write(str: String): Boolean
    fun enableTimeAppendix(enable: Boolean)
}

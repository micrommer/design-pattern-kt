package factorymethod

/**
 * The super class (Creator) that contains an abstract method that force all subclasses to implement the method.
 * The class also could have business logic inside
 */
abstract class Printer {
    fun printArray(vararg arr: String) {
        val specification = getSpecification()
        print(specification.getStarter())
        arr.forEach {
            print(it + specification.getLineSeparator())
        }
        print(specification.getFinisher())
    }

    abstract fun getSpecification(): WriteSpecification
}

/**
 * The product interface.
 */
interface WriteSpecification {
    fun getLineSeparator(): String
    fun getStarter(): String
    fun getFinisher(): String
}

/**
 * Concrete product impl
 */
class WindowsWriteSpecification : WriteSpecification {
    override fun getLineSeparator() = ","
    override fun getStarter() = "---\n"
    override fun getFinisher() = "\n---"
}

/**
 * Concrete product impl
 */
class MacOsWriteSpecification : WriteSpecification {
    override fun getLineSeparator() = "-"
    override fun getStarter() = "In the name of God\n"
    override fun getFinisher() = "\n."
}

/**
 * Concrete product impl
 */
class LinuxWriteSpecification : WriteSpecification {
    override fun getLineSeparator() = " "
    override fun getStarter() = "$\n"
    override fun getFinisher() = "\n$$$"
}

/**
 * Subclass that impl the abstract method
 */
class WindowsPrinter : Printer() {
    override fun getSpecification(): WriteSpecification = WindowsWriteSpecification()
}

/**
 * Subclass that impl the abstract method
 */
class MacPrinter : Printer() {
    override fun getSpecification(): WriteSpecification = MacOsWriteSpecification()
}

/**
 * Subclass that impl the abstract method
 */
class LinuxPrinter : Printer() {
    override fun getSpecification(): WriteSpecification = LinuxWriteSpecification()
}

fun main() {
    val osName = "MAC"
    val printer: Printer = when (osName.lowercase()) {
        "mac" -> MacPrinter()
        "windows" -> WindowsPrinter()
        "linux" -> LinuxPrinter()
        else -> {
            throw NotImplementedError()
        }
    }
    printer.printArray("Hello", "World", "Are", "You", "OK", "!")
}
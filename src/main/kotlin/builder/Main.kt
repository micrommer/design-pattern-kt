package builder

fun main() {
    val curl = CurlBuilder()
    SecureServerPingingDirector(curl).make()
    println(curl.getResult())
}
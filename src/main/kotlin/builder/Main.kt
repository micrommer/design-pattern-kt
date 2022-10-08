package builder

fun main() {
    val curl = CurlBuilder()
    SecureServerPingingDirector(curl).make()
    println("Curl request result ${curl.getResult()}")

    val httpRequestVolatilityCheckerBuilder = HttpRequestVolatilityCheckerBuilder()
    SecureServerPingingDirector(httpRequestVolatilityCheckerBuilder).make()
    println("The request score is ${httpRequestVolatilityCheckerBuilder.getResult()}")
}
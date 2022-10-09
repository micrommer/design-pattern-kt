package prototype

import kotlin.random.Random
import kotlin.random.nextInt

// Prototype registry
val prototypeRegistry = hashMapOf(
    Pair(1, KafkaConfigPrototype("localhost", "5081", "2")),
    Pair(2, RabbitMqConfigPrototype("192.168.1.23", "5111", "requests")),
)

/**
 * Here, in the application perspective, there is no difference between brokers that the application uses. The application
 * doesn't care about implementation details, it could clone what is required for the business.
 */
fun main(vararg args: String) {
    val dispatchSize = if (args.isNotEmpty()) args[0] as Int else 10
    val threadPool = mutableListOf<Thread>()
    for (i in 0..dispatchSize) {
        threadPool.add(Thread {
            val broker = prototypeRegistry[Random.nextInt(IntRange(1, 2))]!!.clone()
            println("I'm using a clone of ${broker.brokerName()} effortlessly!")
        })
    }
    threadPool.forEach{
        it.start()
    }

}

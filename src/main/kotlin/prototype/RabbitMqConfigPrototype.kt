package prototype

import java.time.LocalDateTime

class RabbitMqConfigPrototype(
    private var address: String,
    private var port: String,
    private var topicName: String
) : MessageBrokerConfigPrototype {
    private var field1 = "field1Value"
    private var field2 = "field2Value"
    private var field3 = "field3Value"
    private var field4 = "field4Value"

    private var startTime: LocalDateTime? = null

    override fun clone(): MessageBrokerConfigPrototype {
        return RabbitMqConfigPrototype(address, port, topicName).apply {
            startTime = LocalDateTime.now()
        }
    }

    override fun brokerName() = "'RABBITMQ at $startTime'"
}
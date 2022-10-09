package prototype

class KafkaConfigPrototype(
    private var address: String,
    private var port: String,
    private var partitionNumber: String
) : MessageBrokerConfigPrototype {
    private var field1 = "field1Value"
    private var field2 = "field2Value"
    private var field3 = "field3Value"
    private var field4 = "field4Value"
    private var field5 = "field5Value"
    private var field6 = "field6Value"
    private var field7 = "field7Value"

    private var startTime: Long? = null

    override fun clone(): MessageBrokerConfigPrototype {
        return KafkaConfigPrototype(address, port, partitionNumber).apply {
            startTime = System.currentTimeMillis()
        }
    }

    override fun brokerName() = "'KAFKA at $startTime'"
}
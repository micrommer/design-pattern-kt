package prototype

/**
 * Prototype interface contains essential clone() method and extra method that belongs to business logic.
 * By using this interface, clients don't need to know about concrete impl of classes to be able to copy that,
 * It makes coping easy and effortless for clients.
 * Extra business logic could be added, but they are not required.
 */
interface MessageBrokerConfigPrototype {
    fun clone(): MessageBrokerConfigPrototype
    fun brokerName(): String
}
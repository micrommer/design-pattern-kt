package facade

fun main() {
    val monitoringFacade = MonitoringFacade()
    monitoringFacade.count("Transaction")
    monitoringFacade.count("Transaction")
    monitoringFacade.time("open-connection") {
        Thread.sleep(200)
    }

    monitoringFacade.count("Transaction")

    monitoringFacade.time("open-connection") {
        Thread.sleep(200)
    }

    monitoringFacade.count("Transaction")
}
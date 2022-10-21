package composite

import java.net.URL

fun main() {
    val app = createApp()
    assert(app.resourceSize() > 0)
    println("App resource on startup : ${app.resourceSize()}")
    app.allocateMore()
    println("App resource after allocation : ${app.resourceSize()}")
    app.clearResource()
    assert(app.resourceSize() == 0)
    println("App resource after clean up : ${app.resourceSize()}")
}

/**
 * Create a tree like structure for application
 */
fun createApp(): ManageableServiceRegistry {
    val databaseConnection = UrlService().apply {
        addUrl(URL("https", "localhost", 9989, "usr/con"))
        addUrl(URL("https", "192.168.1.1", 9999, "usr/con"))
        addUrl(URL("https", "192.168.1.2", 9999, "usr/con"))
    }
    val databaseQuery = QueryService().apply {
        addQuery("select * from admin")
        addQuery("select username from user")
    }
    val database = ManageableServiceRegistry().apply {
        add(databaseQuery)
        add(databaseConnection)
    }

    val healthChecker = UrlService().apply {
        addUrl(URL("https", "localhost", 9911, "usr/health"))
        addUrl(URL("https", "localhost", 9912, "usr/health2"))
        addUrl(URL("https", "localhost", 9913, "usr/health3"))
    }
    val accountingServices = UrlService().apply {
        addUrl(URL("https", "192.168.1.3", 8080, "usr/company4/con"))
    }

    val paymentServices = UrlService().apply {
        addUrl(URL("https", "192.168.1.4", 8081, "usr/company4/con"))
    }
    val externalApi = ManageableServiceRegistry().apply {
        add(accountingServices)
        add(paymentServices)
    }
    val httpClient = ManageableServiceRegistry().apply {
        add(healthChecker)
        add(externalApi)
    }
    return ManageableServiceRegistry().apply {
        add(database)
        add(healthChecker)
    }
}
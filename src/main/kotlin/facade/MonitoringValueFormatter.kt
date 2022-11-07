package facade

class MonitoringValueFormatter {
    fun extract(id: String, candida: String): String? {
        return if (candida.startsWith(id))
            candida.split(":")[1]
        else
            null
    }

    fun format(id: String, value: String) = "$id : $value"
}
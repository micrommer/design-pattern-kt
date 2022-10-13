package singleton

fun main() {
    val firstInstance = SystemDirManager.getInstance()
    val secondInstance = SystemDirManager.getInstance()
    assert(secondInstance == firstInstance)
    firstInstance.create("/etc")
    firstInstance.create("/jdk")
    firstInstance.create("/hotspots")
    println(secondInstance.getAll())

    //--------------------KT------------------------

    val ktSingleton = SystemDirManagerKt
    ktSingleton.create("/kotlin")
    ktSingleton.create("/js")
    ktSingleton.create("/java")
    assert(ktSingleton == SystemDirManagerKt)
    println(SystemDirManagerKt.getAll())
}
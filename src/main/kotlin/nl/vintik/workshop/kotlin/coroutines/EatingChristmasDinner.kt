package nl.vintik.workshop.kotlin.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import nl.vintik.workshop.kotlin.basics.Unicorn
import nl.vintik.workshop.kotlin.basics.UnicornHouse
import nl.vintik.workshop.kotlin.basics.UnicornType
import java.util.*
import kotlin.random.Random

// Check out what zip does
// Debug to see coroutines working
// What is unusual in the restaurant?
// Fill unicorn house with unicorns
// Let unicorns eat Christmas dinner, display name of unicorn for each println within coroutine scope

val unicorns = listOf(
        Unicorn(
                UUID.randomUUID(), "Bob", UnicornType.MALICORN, 20, 10, "Bad unicorn"
        ), Unicorn(
        UUID.randomUUID(), "Jane", UnicornType.UNICORN, 10, 30, "Euro unicorn"
), Unicorn(
        UUID.randomUUID(), "John", UnicornType.DEMICORN, null, null, null
)
)

val plates = listOf(
        "Stuffed Turkey",
        "Roast Potatoes",
        "Pigs in Blankets",
        "Yorkshire Pudding",
        "Brussel Sprouts"
).zip(listOf("30", "20", "15", "20", "15"))

fun main() {
    runBlocking {
        eatChristmasDinner()
    }
}
suspend fun eatChristmasDinner() {
    coroutineScope {

        val unicornHouse = UnicornHouse()
        unicornHouse.bulkEnter(*unicorns.toTypedArray())
        unicorns.forEach {
            println("${it.name} is sitting down to eat")
            delay(Random.nextLong(100, 3000))
            println("${it.name} is waiting for food")
            delay(Random.nextLong(100, 3000))
            plates.forEach { plate ->
                launch {
                    serveAndEat(it, plate)
                }
            }
        }
    }
    println("Is everyone done?")
}

suspend fun serveAndEat(unicorn: Unicorn, plate: Pair<String, String>) {
    val (dish, size) = plate
    delay(Random.nextLong(100, 3000))
    println("[${unicorn.name}] got my food, let me start eating this: $dish that's $size cm")
    delay(Random.nextLong(100, 3000))
    println("[${unicorn.name}] done eating: $dish that's $size cm")
}

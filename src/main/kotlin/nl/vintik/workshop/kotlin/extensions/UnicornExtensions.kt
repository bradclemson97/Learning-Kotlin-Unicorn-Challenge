package nl.vintik.workshop.kotlin.extensions

import nl.vintik.workshop.kotlin.basics.Unicorn
import nl.vintik.workshop.kotlin.basics.UnicornType

fun Unicorn.toMalicorn(): Unicorn = this.apply {
    type = UnicornType.MALICORN
}
//"Implement extension function with Unicorn as receiver"

fun Unicorn.computePower(): Int? = magic?.let { magic -> size?.let { size -> size * magic }}
//"Implement extension function with Unicorn as receiver"

fun List<Unicorn>.filterByType(vararg unicornType: UnicornType): List<Unicorn> = this.filter { it.type in unicornType }
//"Implement extension function with List<Unicorn> as receiver"

fun List<Unicorn>.filterBySize(sizeFrom: Int): List<Unicorn> = this.filter { compareValues(it.size, sizeFrom) >= 0 }
//"Implement extension function with List<Unicorn> as receiver"

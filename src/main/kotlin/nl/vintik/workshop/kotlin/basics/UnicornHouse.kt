package nl.vintik.workshop.kotlin.basics

import nl.vintik.workshop.kotlin.extensions.filterBySize
import nl.vintik.workshop.kotlin.extensions.filterByType
import java.util.UUID

class UnicornHouse {
    /**
     * Collections such as list or map by default are immutable, you need to explicitly specify one as mutable
     * For more see https://kotlinlang.org/docs/list-operations.html
     */
    val unicorns = mutableListOf<Unicorn>()

    /**
     * When expression example, for more see https://kotlinlang.org/docs/control-flow.html#when-expression
     * @param unicorn is defined as not null
     */
    fun enter(unicorn: Unicorn): String {
      // "Add unicorn to unicorns list"
        unicorns.add(unicorn)
     // "Print unicorn description if it is not null"
        unicorn.description?.let { println(it) }
       // "Print a welcome message for each unicorn type, see unit test UnicornHouseTest for expected message"
        return when(unicorn.type){
            UnicornType.UNICORN -> "Welcome European Unicorn ${unicorn.name}"
            UnicornType.MALICORN -> "Welcome Malicious Unicorn ${unicorn.name}"
            UnicornType.DEMICORN -> "Welcome Demon Unicorn ${unicorn.name}"
        }
    }

    fun bulkEnter(vararg unicorn: Unicorn) = unicorn.map {enter(it)}
    //"Implement method that executes enter(unicorn) for each unicorn and return all welcome messages as list"

    fun exit(unicornId: UUID): Boolean = unicorns.removeIf {it.id ==unicornId}
    //"Should remove unicorn from unicorn list returning true on success otherwise false"


    fun countUnicorns(): Int = unicorns.count()
    //"count unicorns in unicorn list"

    fun countUnicornsByType(unicornType: UnicornType): Int = unicorns.count {it.type ==unicornType}
    //"count unicorns of given unicorn type in unicorn list "

    fun mapUnicornsByType(): Map<UnicornType, Unicorn> = unicorns.associateBy { it.type }
    //"Convert unicorn list to a map keyed by unicorn type. If any two elements would have the same key, then the last one gets added to the map"

    fun orderUnicornsBySizeDescending(): List<Unicorn> = unicorns.sortedByDescending { it.size }
    //"Return a list of all unicorns (from unicorns list) sorted in descending order of unicorn size"

    fun totalMagicInDaHouse(): Int = unicorns.sumOf { it.magic ?:0 }
    //"Return the some of magic property (if present) of all unicorns in unicorn list"

    fun filterUnicornsByType(vararg unicornType: UnicornType): List<Unicorn> = unicorns.filterByType(*unicornType)

    fun filterUnicornsBySize(sizeFrom: Int) =
        unicorns.filterBySize(sizeFrom)

}
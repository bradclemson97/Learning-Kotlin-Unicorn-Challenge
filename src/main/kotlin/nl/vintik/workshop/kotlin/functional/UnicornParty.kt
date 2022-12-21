package nl.vintik.workshop.kotlin.functional

import nl.vintik.workshop.kotlin.basics.Unicorn
import nl.vintik.workshop.kotlin.basics.UnicornHouse
import nl.vintik.workshop.kotlin.basics.UnicornType
import nl.vintik.workshop.kotlin.extensions.filterByType


fun UnicornHouse.partyHardy(): List<String> {
    //function composition with infix
    val faceControl = ::onlyBig and ::onlyBad
         //   "Allow only big and bad unicorns to the party"
    return party(faceControl)
}

fun UnicornHouse.partyMildly(): List<String> {
    val faceControl = ::onlyGood
    return party(faceControl)
}

private fun UnicornHouse.party(faceControl: (List<Unicorn>) -> List<Unicorn>) =
    faceControl.invoke(this.unicorns).map { it.name }


private fun onlyBig(unicorns: List<Unicorn>): List<Unicorn> = unicorns.filter { compareValues(it.size, 10) > 0}
//"Filter given unicorns by size starting from 10 inclusive"

private fun onlyGood(unicorns: List<Unicorn>) = unicorns.filterByType(UnicornType.UNICORN, UnicornType.DEMICORN)

private fun onlyBad(unicorns: List<Unicorn>) = unicorns.filterByType(UnicornType.MALICORN)

private infix fun ((List<Unicorn>) -> List<Unicorn>).and(other: (List<Unicorn>) -> List<Unicorn>): (List<Unicorn>) -> List<Unicorn> =
    { other(this(it)) }

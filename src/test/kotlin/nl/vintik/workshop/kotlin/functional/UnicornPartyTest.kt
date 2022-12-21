package nl.vintik.workshop.kotlin.functional

import nl.vintik.workshop.kotlin.basics.Unicorn
import nl.vintik.workshop.kotlin.basics.UnicornHouse
import nl.vintik.workshop.kotlin.basics.UnicornType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class UnicornPartyTest {

    private lateinit var unicornHouse: UnicornHouse
    private lateinit var badUnicorn: Unicorn
    private lateinit var anotherBadUnicorn: Unicorn
    private lateinit var europeanUnicorn: Unicorn
    private lateinit var mildUnicorn: Unicorn

    @BeforeEach
    fun setUp() {
        unicornHouse = UnicornHouse()
        badUnicorn = Unicorn(
            UUID.randomUUID(),
            "Bob",
            UnicornType.MALICORN,
            20,
            10,
            "Bad unicorn"
        )
        anotherBadUnicorn = Unicorn(
            UUID.randomUUID(),
            "Betty",
            UnicornType.MALICORN,
            30,
            5,
            "Bad unicorn"
        )
        europeanUnicorn = Unicorn(
            UUID.randomUUID(),
            "Jane",
            UnicornType.UNICORN,
            10,
            30,
            "Euro unicorn"
        )
        mildUnicorn = Unicorn(
            UUID.randomUUID(),
            "John",
            UnicornType.DEMICORN,
            null,
            null,
            null
        )

        unicornHouse.bulkEnter(badUnicorn, anotherBadUnicorn, europeanUnicorn, mildUnicorn)
    }

    @Test
    fun `should allow only big and bad unicorns to party hardy`() {
        val result = unicornHouse.partyHardy()
        assertEquals(2, result.size)
        assertTrue("Bob" in result)
        assertTrue("Betty" in result)
    }

    @Test
    fun `should allow only good unicorns to party mildly`() {
        val result = unicornHouse.partyMildly()
        assertEquals(2, result.size)
        assertTrue("Jane" in result)
        assertTrue("John" in result)
    }
}
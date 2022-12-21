package nl.vintik.workshop.kotlin.extensions

import nl.vintik.workshop.kotlin.basics.Unicorn
import nl.vintik.workshop.kotlin.basics.UnicornType
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class UnicornExtensionsKtTest {

    @Test
    fun `should convert to any unicorn to malicorn`() {
        val unicorn = Unicorn(
            UUID.randomUUID(),
            "Nelly",
            UnicornType.DEMICORN,
            null,
            null,
            null
        )
        val result = unicorn.toMalicorn()
        assertEquals(UnicornType.MALICORN, result.type)
    }

    @Test
    fun `should not compute unicorn power when size or magic null `() {
        val unicorn = Unicorn(
            UUID.randomUUID(),
            "Nelly",
            UnicornType.UNICORN,
            null,
            null,
            null
        )
        val result = unicorn.computePower()
        assertNull(result)
    }

    @Test
    fun `should compute unicorn power when size and magic are set `() {
        val unicorn = Unicorn(
            UUID.randomUUID(),
            "Nelly",
            UnicornType.UNICORN,
            10,
            2,
            null
        )
        val result = unicorn.computePower()
        assertEquals(20, result)
    }
}
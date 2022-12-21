package nl.vintik.workshop.kotlin.basics

import java.util.UUID

data class Unicorn(
        val id: UUID,
        val name: String,
        var type: UnicornType,
        /**
     * Nullable fields are explicit https://kotlinlang.org/docs/null-safety.html#nullable-types-and-non-null-types
     */
    val size: Int?,
        val magic: Int?,
        val description: String?
)
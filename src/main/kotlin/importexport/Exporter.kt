package flashcards.importexport

import flashcards.card.MutableDeck
import flashcards.card.MutableStats
import java.io.File

class Exporter(private val deck: MutableDeck, private val stats: MutableStats) {
    fun export(fileName: String): Int {
        val file = File(fileName.ifBlank { "deck.txt" })

        deck.joinToString("\n") { card -> "${stats.getError(card)} -> ${card.term} -> ${card.definition}" }
            .also { file.writeText(it) }

        return deck.count()
    }
}

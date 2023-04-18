package flashcards.importexport

import flashcards.card.Card
import flashcards.card.MutableDeck
import flashcards.card.MutableStats
import java.io.File

class Importer(private val deck: MutableDeck, private val stats: MutableStats) {
    fun import(fileName: String): Int {
        val file = File(fileName.ifBlank { "deck.txt" })
        var importCount = 0

        if (!file.canRead()) {
            throw Exception("File not found.")
        }

        file.forEachLine {
            if (!it.contains(" -> ")) {
                return@forEachLine
            }

            val (count, term, definition) = it.split(" -> ", limit = 3)
            deck.addOrReplace(Card(term, definition))
            stats.setError(term, count.toIntOrNull() ?: 0)
            ++importCount
        }

        return importCount
    }
}

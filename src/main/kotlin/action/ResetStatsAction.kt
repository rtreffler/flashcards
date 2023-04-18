package flashcards.action

import flashcards.card.MutableStats
import flashcards.io.IO

class ResetStatsAction(private val io: IO, private val stats: MutableStats): Action {
    override fun name(): String = "reset stats"

    override fun handle() {
        stats.reset()
        io.println("Card statistics have been reset.")
    }
}

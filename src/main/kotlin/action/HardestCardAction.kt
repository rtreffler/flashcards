package flashcards.action

import flashcards.card.Stats
import flashcards.io.IO

class HardestCardAction(private val io: IO, private val stats: Stats): Action {
    override fun name(): String = "hardest card"

    override fun handle() {
        with (stats.getHardest()) {
            io.println(when (this.count()) {
                0 -> "There are no cards with errors."
                1 -> "The hardest card is \"${this.keys.first()}\". You have ${this.values.first()} errors answering it."
                else -> "The hardest cards are " + this.keys.joinToString(", ") { "\"$it\"" } + ". You have ${this.values.first()} errors answering them."
            })
        }
    }
}

package flashcards.action

import flashcards.card.Card
import flashcards.card.Deck
import flashcards.card.MutableStats
import flashcards.io.IO

class AskAction(private val io: IO, private val deck: Deck, private val stats: MutableStats): Action {
    override fun name(): String = "ask"

    override fun handle() {
        val count = io.ask("How many times to ask?").toInt()

        repeat (count) {
            val card = deck.getRandomCard()
            val answer = io.ask("Print the definition of \"${card.term}\":")

            if (answer != card.definition) {
                stats.incError(card)
                deck.findCardByDefinition(answer).also {
                    io.println(
                        if (it is Card) {
                            "Wrong. The right answer is \"${card.definition}\", but your definition is correct for \"${it.term}\"."
                        } else {
                            "Wrong. The right answer is \"${card.definition}\"."
                        }
                    )
                }
            } else {
                io.println("Correct!")
            }
        }
    }
}

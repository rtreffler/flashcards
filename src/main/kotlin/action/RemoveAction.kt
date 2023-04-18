package flashcards.action

import flashcards.card.Card
import flashcards.card.MutableDeck
import flashcards.io.IO

class RemoveAction(private val io: IO, private val deck: MutableDeck): Action {
    override fun name(): String = "remove"

    override fun handle() {
        val term = io.ask("Which card?")

        io.println(if (deck.removeCardByTerm(term) is Card) {
            "The card has been removed."
        } else {
            "Can't remove \"$term\": there is no such card."
        })
    }
}

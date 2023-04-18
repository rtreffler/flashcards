package flashcards.action

import flashcards.card.Card
import flashcards.card.MutableDeck
import flashcards.io.IO

class AddAction(private val io: IO, private val deck: MutableDeck): Action {
    override fun name(): String = "add"

    override fun handle() {
        val term = io.ask("The card:")
        if (deck.hasTerm(term)) {
            io.println("The card \"$term\" already exists.")
            return
        }

        val definition = io.ask("The definition of the card:")
        if (deck.hasDefinition(definition)) {
            io.println("The definition \"$definition\" already exists.")
            return
        }

        deck.addCard(Card(term, definition))
        io.println("The pair (\"$term\":\"$definition\") has been added.")
    }
}

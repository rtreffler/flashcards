package flashcards.card

interface MutableDeck: Deck {
    fun addCard(card: Card): Boolean
    fun addOrReplace(card: Card): Boolean
    fun removeCardByTerm(term: String): Card?
}

package flashcards.card

interface Deck: Iterable<Card> {
    fun hasTerm(term: String): Boolean
    fun findCardByTerm(term: String): Card?
    fun hasDefinition(definition: String): Boolean
    fun findCardByDefinition(definition: String): Card?
    fun getRandomCard(): Card
    fun count(): Int
}

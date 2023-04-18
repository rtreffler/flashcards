package flashcards.card

import kotlin.random.Random

class DeckImpl: MutableDeck  {
    private val cards = mutableListOf<Card>()

    override fun hasTerm(term: String): Boolean {
        return cards.count { it.term == term } > 0
    }

    override fun findCardByTerm(term: String): Card? {
        return cards.find { it.term == term }
    }

    override fun hasDefinition(definition: String): Boolean {
        return cards.count { it.definition == definition } > 0
    }

    override fun findCardByDefinition(definition: String): Card? {
        return cards.find { it.definition == definition }
    }

    override fun getRandomCard(): Card {
        return cards[Random.nextInt(cards.size)]
    }

    override fun count(): Int {
        return cards.count()
    }

    override fun iterator(): Iterator<Card> {
        return cards.iterator()
    }

    override fun addCard(card: Card): Boolean {
        if (hasTerm(card.term)) {
            return false
        }

        return cards.add(card)
    }

    override fun addOrReplace(card: Card): Boolean {
        removeCardByTerm(card.term)

        return cards.add(card)
    }

    override fun removeCardByTerm(term: String): Card? {
        return findCardByTerm(term).also {
            cards.remove(it)
        }
    }
}

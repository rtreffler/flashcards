package flashcards.card

interface Stats {
    fun getHardest(): Map<String, Int>
    fun getError(term: String): Int
    fun getError(card: Card): Int
}

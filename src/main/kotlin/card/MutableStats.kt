package flashcards.card

interface MutableStats: Stats {
    fun incError(term: String)
    fun incError(card: Card)
    fun setError(term: String, count: Int)
    fun setError(card: Card, count: Int)
    fun reset()
}

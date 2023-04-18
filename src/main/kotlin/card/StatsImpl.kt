package flashcards.card

class StatsImpl: MutableStats {
    private val stats = mutableMapOf<String, Int>()

    override fun getHardest(): Map<String, Int> {
        val max = stats.maxByOrNull { it.value }

        return stats.filter { it.value == max?.value }
    }

    override fun getError(term: String): Int = stats.getOrDefault(term, 0)

    override fun getError(card: Card): Int = getError(card.term)

    override fun incError(term: String) {
        stats[term] = stats.getOrDefault(term, 0) + 1
    }

    override fun incError(card: Card) = incError(card.term)

    override fun setError(term: String, count: Int) {
        stats[term] = count
    }

    override fun setError(card: Card, count: Int) = setError(card.term, count)

    override fun reset() = stats.clear()
}

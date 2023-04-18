package flashcards.action

interface Action {
    fun name(): String
    fun handle()
}

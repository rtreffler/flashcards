package flashcards.io

interface Logger {
    fun log(message: String)
    fun getLog(): List<String>
}
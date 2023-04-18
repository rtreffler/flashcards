package flashcards.io

class IO(private val logger: Logger) {
    fun println(message: String) {
        kotlin.io.println(message)
        logger.log(message)
    }

    fun readln(): String {
        val response = kotlin.io.readln()

        logger.log(response)

        return response
    }

    fun ask(message: String): String {
        println(message)

        return readln()
    }
}

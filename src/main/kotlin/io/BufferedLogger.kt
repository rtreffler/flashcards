package flashcards.io

class BufferedLogger: Logger {
    private val log = mutableListOf<String>()

    override fun log(message: String) {
        log.add(message)
    }

    override fun getLog(): List<String> {
        return log
    }
}
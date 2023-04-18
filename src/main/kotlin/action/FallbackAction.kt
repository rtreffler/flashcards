package flashcards.action

import flashcards.io.IO

class FallbackAction(private val io: IO, private val taskName: String): Action {
    override fun name(): String = "fallback"

    override fun handle() {
        io.println("Wrong task: $taskName")
    }
}

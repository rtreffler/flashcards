package flashcards.action

import flashcards.io.IO

class ExitAction(private val io: IO): Action {
    override fun name(): String = "exit"

    override fun handle() {
        io.println("Bye bye!")
    }
}

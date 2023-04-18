package flashcards.action

import flashcards.io.IO
import flashcards.io.Logger
import java.io.File
import java.time.OffsetDateTime

class LogAction(private val io: IO, private val logger: Logger): Action {
    override fun name(): String = "log"

    override fun handle() {
        val file = File(io.ask("File name:").ifBlank { "log_${OffsetDateTime.now().toEpochSecond()}.txt" })

        logger.getLog()
            .joinToString("\n")
            .also { file.writeText(it) }

        io.println("The log has been saved.")
    }
}

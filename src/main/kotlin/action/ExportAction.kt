package flashcards.action

import flashcards.importexport.Exporter
import flashcards.io.IO

class ExportAction(private val io: IO, private val exporter: Exporter): Action {
    override fun name(): String = "export"

    override fun handle() {
        val fileName = io.ask("File name:").ifBlank { "deck.txt" }

        try {
            val exportCount = exporter.export(fileName)
            io.println("$exportCount cards have been saved.")
        } catch (e: Exception) {
            io.println(e.message ?: "Unknown error while reading $fileName file.")
        }
    }
}

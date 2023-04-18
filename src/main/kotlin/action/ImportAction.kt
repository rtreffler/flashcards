package flashcards.action

import flashcards.importexport.Importer
import flashcards.io.IO

class ImportAction(private val io: IO, private val importer: Importer): Action {
    override fun name(): String = "import"

    override fun handle() {
        val fileName = io.ask("File name:").ifBlank { "deck.txt" }

        try {
            val importCount = importer.import(fileName)
            io.println("$importCount cards have been loaded.")
        } catch (e: Exception) {
            io.println(e.message ?: "Unknown error while reading $fileName file.")
        }
    }
}

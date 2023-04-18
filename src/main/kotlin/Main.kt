package flashcards

import flashcards.action.*
import flashcards.card.DeckImpl
import flashcards.card.StatsImpl
import flashcards.importexport.Exporter
import flashcards.importexport.Importer
import flashcards.io.BufferedLogger
import flashcards.io.IO

fun main(args: Array<String>) {
    val logger = BufferedLogger()
    val io = IO(logger)
    val stats = StatsImpl()
    val deck = DeckImpl()
    val importer = Importer(deck, stats)
    val exporter = Exporter(deck, stats)
    val actionCollection = ActionCollection(io, listOf(
        AddAction(io, deck),
        RemoveAction(io, deck),
        ImportAction(io, importer),
        ExportAction(io, exporter),
        AskAction(io, deck, stats),
        ExitAction(io),
        LogAction(io, logger),
        HardestCardAction(io, stats),
        ResetStatsAction(io, stats)
    ))
    var action: Action

    if (args.contains("-import")) {
        val importCount = importer.import(args[args.indexOf("-import") + 1])
        io.println("$importCount cards have been loaded.")
    }

    do {
        io.println("Input the action (${actionCollection.getAvailableActionsNames().joinToString()}):")
        action = actionCollection.get(io.readln())
        action.handle()
    } while (action !is ExitAction)

    if (args.contains("-export")) {
        val importCount = exporter.export(args[args.indexOf("-export") + 1])
        io.println("$importCount cards have been saved.")
    }
}

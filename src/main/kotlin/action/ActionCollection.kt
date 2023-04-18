package flashcards.action

import flashcards.io.IO

class ActionCollection(private val io: IO, listOfActions: List<Action>) {
    private val actions = mutableMapOf<String, Action>()

    init {
        listOfActions.forEach { add(it) }
    }

    fun add(action: Action) {
        actions[action.name()] = action
    }

    fun getAvailableActionsNames(): List<String> = actions.map { it.key }

    fun get(actionName: String): Action = actions[actionName] ?: FallbackAction(io, actionName)
}

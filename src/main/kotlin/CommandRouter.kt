import javax.inject.Inject

class CommandRouter @Inject constructor() {

    private val commands: Map<String, Command> = emptyMap<String, Command>()

    fun route(input: String): Result {
        val splitInput = split(input)

        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }

        val commandKey = splitInput[0]
        val command = commands[commandKey]
        if (command == null) {
            return invalidCommand(input)
        }

        val args = splitInput.subList(1, splitInput.count())
        val result = command.handleInput(args)

        return if (result.status() == Status.INVALID) {
            invalidCommand(input)
        } else {
            result
        }
    }

    private fun invalidCommand(input: String): Result {
        println("couldn't understand \"${input}\". please try again.")
        return Result.invalid()
    }

    private fun split(input: String): List<String> =
        input.trim().split("\\s+").toList()
}
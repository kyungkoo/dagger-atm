interface Command {
    fun key(): String
    fun handleInput(input: List<String>): Result
}

class Result(private val status: Status) {

    companion object {
        fun invalid(): Result = Result(Status.INVALID)
        fun handled(): Result = Result(Status.HANDLED)
    }

    fun status(): Status = status
}


enum class Status {
    INVALID, HANDLED
}

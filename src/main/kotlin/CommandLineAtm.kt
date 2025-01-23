fun main() {

    val commandRouterFactory = DaggerCommandRouterFactory.create()
    val commandRouter = commandRouterFactory.router()

    while (true) {
        val input = readlnOrNull()
        if (input == null || input.isEmpty()) {
            println("There is no input. exit program.")
            break
        }

        val unused = commandRouter.route(input)
    }
}
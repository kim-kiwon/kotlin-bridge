package bridge

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(userInput: String): Int {
        val bridgeSize = userInput.toIntOrNull() ?:
            throw IllegalArgumentException("BridgeSize must be integer")

        if (bridgeSize < 3 || bridgeSize > 20) {
            throw IllegalArgumentException("BridgeSize must be between 3 and 20")
        }

        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(userInput: String): String {
        return when(userInput) {
            "U" -> "U"
            "D" -> "D"
            else -> throw IllegalArgumentException("Moving must be U or D")
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(userInput: String): String {
        return when(userInput) {
            "R" -> "R"
            "Q" -> "Q"
            else -> throw IllegalArgumentException("Game command must be R or Q")
        }
    }
}

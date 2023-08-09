package bridge

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val answerBridge: List<String>) {
    val userBridge = mutableListOf<String>()
    val moveSuccess = mutableListOf<Boolean>()
    var isQuit = false
    var userLocation = 0
    var tryCount = 1

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(moving: String): Boolean {
        val canMove = (answerBridge[userLocation] == moving)

        userBridge.add(moving)
        moveSuccess.add(canMove)

        if (canMove) userLocation++

        return canMove
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        userBridge.clear()
        moveSuccess.clear()
        userLocation = 0
        tryCount++
    }

    fun getUserBridgeMap(): String{
        val upSb = StringBuilder()
        val downSb = StringBuilder()

        for (i in 0 until userBridge.size) {
            upSb.append("[ ${getUpMark(userBridge[i], moveSuccess[i])} ")
            downSb.append("[ ${getDownMark(userBridge[i], moveSuccess[i])} ")

            upSb.append(getCloseOrContinueMark(i, userBridge))
            downSb.append(getCloseOrContinueMark(i, userBridge))
        }

        return """
            $upSb
            $downSb
        """.trimIndent()
    }

    fun isSuccess(): Boolean {
        return moveSuccess.size == answerBridge.size && moveSuccess.all { it == true }
    }

    private fun getCloseOrContinueMark(i: Int, userBridge: List<String>): String {
        if (i == userBridge.lastIndex) {
            return "]"
        }
        return "| "
    }

    private fun getUpMark(userPick: String, moveSuccess: Boolean): String {
        return when {
            (userPick == "U" && moveSuccess) -> "O"
            (userPick == "U" && !moveSuccess) -> "X"
            else -> " "
        }
    }

    private fun getDownMark(userPick: String, moveSuccess: Boolean): String {
        return when {
            (userPick == "D" && moveSuccess) -> "O"
            (userPick == "D" && !moveSuccess) -> "X"
            else -> " "
        }
    }
}

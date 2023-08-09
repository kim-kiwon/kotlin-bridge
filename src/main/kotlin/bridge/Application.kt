package bridge

import camp.nextstep.edu.missionutils.Console

fun main() {
    // Start bridgeGame
    val inputView = InputView()
    val bridgeGame = startBridgeGame(inputView)

    // Play bridgeGame
    val outputView = OutputView()
    playBridgeGame(bridgeGame, inputView, outputView)

    // Print results
    printResults(bridgeGame, outputView)
}

private fun startBridgeGame(inputView: InputView): BridgeGame {
    println("다리 건너기 게임을 시작합니다.")
    println()
    println("다리의 길이를 입력해주세요.")

    // Receive bridge size
    val bridgeSize = inputView.readBridgeSize(Console.readLine())

    // Make answer bridge and bridgeGame
    val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
    val answerBridge = bridgeMaker.makeBridge(bridgeSize)
    return BridgeGame(answerBridge)
}

private fun playBridgeGame(bridgeGame: BridgeGame, inputView: InputView, outputView: OutputView) {
    while(!bridgeGame.isSuccess() && !bridgeGame.isQuit) {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val moving = inputView.readMoving(Console.readLine())

        val isMove = bridgeGame.move(moving)
        outputView.printMap(bridgeGame.getUserBridgeMap())

        handleMoveResult(isMove, inputView, bridgeGame)
    }
}

private fun handleMoveResult(isMove: Boolean, inputView: InputView, bridgeGame: BridgeGame) {
    if (!isMove) {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        val gameCommand = inputView.readGameCommand(Console.readLine())
        retryOrQuitGame(gameCommand, bridgeGame)
    }
}

private fun retryOrQuitGame(gameCommand: String, bridgeGame: BridgeGame) {
    if (gameCommand == "R") {
        bridgeGame.retry()
        return
    }

    bridgeGame.isQuit = true
}

private fun printResults(bridgeGame: BridgeGame, outputView: OutputView) {
    println()
    println("최종 게임 결과")
    outputView.printMap(bridgeGame.getUserBridgeMap())

    println()
    outputView.printResult(bridgeGame.isSuccess(), bridgeGame.tryCount)
}

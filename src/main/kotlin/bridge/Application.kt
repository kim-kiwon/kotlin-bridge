package bridge

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("다리 건너기 게임을 시작합니다.")
    println()
    println("다리의 길이를 입력해주세요.")
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeSize = inputView.readBridgeSize(Console.readLine())

    val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
    val answerBridge = bridgeMaker.makeBridge(bridgeSize)

    val bridgeGame = BridgeGame(answerBridge)
    var isQuit = false

    while(!bridgeGame.isFinish() && !isQuit) {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val moving = inputView.readMoving(Console.readLine())

        val isMove = bridgeGame.move(moving)
        outputView.printMap(bridgeGame.getUserBridgeMap())

        if (!isMove) {
            println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
            val gameCommand = inputView.readGameCommand(Console.readLine())
            if (gameCommand == "R") {
                bridgeGame.retry()
            } else {
                isQuit = true
            }
        }
    }

    println()
    println("최종 게임 결과")
    outputView.printMap(bridgeGame.getUserBridgeMap())

    println()
    outputView.printResult(bridgeGame.isFinish(), bridgeGame.tryCount)
}

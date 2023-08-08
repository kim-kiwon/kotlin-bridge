## Kotlin-Bridge
### Todo
- [x] Add making answer bridge
- [x] Add bridge game's move with answer bridge 
- [x] Add bridge game's retry that reset move's bridge
- [ ] Add output view
- [x] Add input view

### 책임 분배
- InputView
  - 사용자 입력을 받는 역할을 수행한다.
  - 각 메서드는 입력을 인자로 받자
    - 입력을 인자로 분리해야 해당 메서드 테스트가 가능하다.
  - 입력값 검증, 타입변환 등을 수행한다
- OutputView
  - 사용자에게 print 를 제공한다.
- BridgeGame
  - List<String> 에서 사용자를 이동시킨다.
    - BrdigeMaker 가 생성한 List<String> 과 비교해 move 가 실패할 수 있다.
  - 게임을 다시 시도한다면 List<String> 을 초기화한다.
- BridgeMaker
  - 다리 길이만큼 BridgeRandomNumberGenerator 로 랜덤한 수를 뽑아 위/아래 중 건널 수 있는 칸을 찾는다
  - 수행 결과로 정답 다리를 생성한다.
- BridgeRandomNumberGenerator
  - 0과 1중 랜덤한 값을 반환한다.
  - 해당 반환 값을 바탕으로 다리 위 / 아래 중 어느칸을 건너게 할지 선택한다
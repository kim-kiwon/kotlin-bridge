package bridge

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BridgeGameTest {
    private lateinit var bridgeGame: BridgeGame

    @Test
    fun `succeed move test when moving equals with answer`() {
        bridgeGame = BridgeGame(listOf("U", "U", "D"))

        assertTrue(bridgeGame.move(0, "U"))
        assertEquals(bridgeGame.userBridge[0], "U")
    }

    @Test
    fun `failed move test when moving not equals with answer`() {
        bridgeGame = BridgeGame(listOf("U", "U", "D"))

        assertFalse(bridgeGame.move(0, "D"))
        assertEquals(bridgeGame.userBridge.size, 0)
    }

    @Test
    fun `succeed retry test when retry is called`() {
        bridgeGame = BridgeGame(listOf("U", "U", "D"))
        bridgeGame.move(0, "U")
        bridgeGame.retry()

        assertEquals(bridgeGame.userBridge.size, 0)
    }
}
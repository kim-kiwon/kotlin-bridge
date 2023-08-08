package bridge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    private val inputView = InputView()

    @Test
    fun `succeed readBridgeSize when userInput is between 3 and 20`() {
        assertEquals(inputView.readBridgeSize("20"), 20)
    }

    @Test
    fun `failed readBridgeSize when userInput is not integer string`() {
        assertThrows<IllegalArgumentException> {
            inputView.readBridgeSize("c")
        }
    }

    @Test
    fun `failed readBridgeSize when userInput is not between 3 and 20`() {
        assertThrows<IllegalArgumentException> {
            inputView.readBridgeSize("21")
        }
    }

    @Test
    fun `succeed readMoving when userInput is U or D`() {
        assertEquals(inputView.readMoving("U"), "U")
        assertEquals(inputView.readMoving("D"), "D")
    }

    @Test
    fun `failed readMoving when userInput is not U or D`() {
        assertThrows<IllegalArgumentException> {
            inputView.readMoving("A")
        }
    }

    @Test
    fun `succeed readGameCommand when userInput is R or Q`() {
        assertEquals(inputView.readGameCommand("R"), "R")
        assertEquals(inputView.readGameCommand("Q"), "Q")
    }

    @Test
    fun `failed readGameCommand when userInput is not R or Q`() {
        assertThrows<IllegalArgumentException> {
            inputView.readGameCommand("A")
        }
    }
}
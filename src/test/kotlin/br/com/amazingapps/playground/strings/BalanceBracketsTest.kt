package br.com.amazingapps.playground.strings

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.lang.IllegalArgumentException

class BalanceBracketsTest {

    private val balanceBrackets: BalanceBrackets = BalanceBrackets()
    @Test
    fun balancedBracketsShouldReturnTrue() {
        val data = "f(e(d))"

        assert(balanceBrackets.isBalanced(data))
    }

    @Test
    fun bracketsWithLettersShouldThrowAnError() {
        val data = "f(e(d))"

        assertThrows(IllegalArgumentException::class.java) {
            balanceBrackets.isBalancedAlternative(data)
        }
    }
}
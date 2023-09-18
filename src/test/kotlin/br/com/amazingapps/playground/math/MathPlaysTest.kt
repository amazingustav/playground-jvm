package br.com.amazingapps.playground.math



import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test

class MathPlaysTest {

    private val service = MathPlays()
    @Test
    fun shouldSumDigits() {
        assertEquals(11, service.sumOfDigits(29))
        assertEquals(12, service.sumOfDigits(48))
        assertEquals(1, service.sumOfDigits(10))
        assertEquals(18, service.sumOfDigits(99))
    }

    @Test
    fun shouldSumDigitsUsingAlternativeSolution() {
        assertEquals(11, service.sumOfDigitsAlternative(29))
        assertEquals(12, service.sumOfDigitsAlternative(48))
        assertEquals(1, service.sumOfDigitsAlternative(10))
        assertEquals(18, service.sumOfDigitsAlternative(99))
    }

    @Test
    fun shouldThrowAnErrorWhenDigitIsGreaterThan99() {
        val exception = assertThrows<IllegalArgumentException> { service.sumOfDigitsAlternative(100) }
        assertTrue(exception.message!!.contains("n must be between 10 and 99 inclusive"))
    }
}
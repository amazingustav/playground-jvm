package br.com.amazingapps.playground.math

import br.com.amazingapps.playground.math.SmallestPositiveInt
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestPositiveIntTest {

    private val service = SmallestPositiveInt()

    @Test
    fun shouldReturnTheSmallestIntPossible() {
        val intList = intArrayOf(1, 3, 6, 4, 1, 2)

        assertEquals(5, service.solution(intList))
    }
}
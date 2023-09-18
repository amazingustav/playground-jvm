package br.com.amazingapps.playground.math

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SplitIntegerTest {

    private val split: SplitInteger = SplitInteger()

    @Test
    fun splitInteger() {
        assertEquals(arrayListOf(10), split.splitInteger(10, 1))
        assertEquals(arrayListOf(1, 1), split.splitInteger(2, 2))
        assertEquals(arrayListOf(4, 4, 4, 4, 4), split.splitInteger(20, 5))
    }
}
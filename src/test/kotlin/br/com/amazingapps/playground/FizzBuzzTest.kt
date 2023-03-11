package br.com.amazingapps.playground

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class FizzBuzzTest {

    private val service = FizzBuzz()

    @Test
    fun shouldReplaceNumbersToFizzAndBuzz() {
        val expected = listOf("1", "2", "Fizz", "4", "Buzz")

        assertEquals(expected, service.resolve(5))
    }
}
package br.com.amazingapps.playground.integers

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SmallestPositiveTest {

    private val smallestPositive: SmallestPositive = SmallestPositive()

    @Test
    fun `when missing a positive integer in between it should return 5`() {
        val actual = smallestPositive.solution(intArrayOf(1, 3, 6, 4, 1, 2))
        assertEquals(5, actual)
    }

    @Test
    fun `when all consecutive positive integers from 1 it should return 4`() {
        val actual = smallestPositive.solution(intArrayOf(1, 2, 3))
        assertEquals(4, actual)
    }

    @Test
    fun `when only negative numbers it should return 1`() {
        val actual = smallestPositive.solution(intArrayOf(-1, -3))
        assertEquals(1, actual)
    }

    @Test
    fun `when large range with missing numbers it should return 4`() {
        val actual = smallestPositive.solution(intArrayOf(1, 2, 3, 5))
        assertEquals(4, actual)
    }

    @Test
    fun `when repeated numbers it should return 2`() {
        val actual = smallestPositive.solution(intArrayOf(1, 1, 1, 1))
        assertEquals(2, actual)
    }

    @Test
    fun `when single element positive it should return 2`() {
        val actual = smallestPositive.solution(intArrayOf(1))
        assertEquals(2, actual)
    }

    @Test
    fun `when single element negative it should return 1`() {
        val actual = smallestPositive.solution(intArrayOf(-1))
        assertEquals(1, actual)
    }

    @Test
    fun `when empty array it should return 1`() {
        val actual = smallestPositive.solution(intArrayOf())
        assertEquals(1, actual)
    }

    @Test
    fun `when large array with maximum and minimum values it should return 12345`() {
        val actual = smallestPositive.solution((1..100000).filterNot { it == 12345 }.toIntArray())
        assertEquals(12345, actual)
    }

    @Test
    fun `when array with zeros and negatives it should return 1`() {
        val actual = smallestPositive.solution(intArrayOf(0, -10, -1))
        assertEquals(1, actual)
    }
}
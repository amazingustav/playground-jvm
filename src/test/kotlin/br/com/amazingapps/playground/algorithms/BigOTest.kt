package br.com.amazingapps.playground.algorithms

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BigOTest {

    private val bigO: BigO = BigO()

    @Test
    fun itShouldPrintFirstElementOfaList() {
        val result = bigO.printListContent(listOf(1, 2, 3))
        assert(result == 1)
    }

    @Test
    fun itShouldThrowExceptionWhenListIsEmpty() {
        val exception = assertThrows<Exception> {
            bigO.printListContent(listOf())
        }

        assert(exception.message == "List is empty")
    }

    @Test
    fun itShouldFindValueInList() {
        val result = bigO.findValueInList(listOf(1, 2, 3), 2)
        assert(result)

        val notFoundResult = bigO.findValueInList(listOf(1, 2, 3), 12)
        assert(!notFoundResult)
    }

    @Test
    fun itShouldBubbleSortAList() {
        val result = bigO.bubbleSort(listOf(13, 2, 33))
        assert(result == listOf(2, 13, 33))
    }

    @Test
    fun itShouldBinarySearch() {
        val result = bigO.binarySearch(listOf(1, 2, 3), 2)
        assert(result)

        val notFoundResult = bigO.binarySearch(listOf(1, 2, 3), 10)
        assert(!notFoundResult)
    }
}
package br.com.amazingapps.playground.math

/**
 * In this challenge, you will write a function to divide an integer into a number of even parts,
 * which will be returned in a result array. Summing the integers in this result array will produce the original number.
 *
 * For example, given number = 10 and parts = 2, splitInteger(10, 2) should return an array of integers with
 * length equal to parts: [5, 5].
 *
 * Not all numbers will offer a clean division. In this case, we should split the number
 * as closely as possible to even, with the smaller numbers in the front of the array. For example,
 *
 * splitInteger(11, 3) → [3, 4, 4]
 * There is no reason to test for edge cases; the input to your function will always be valid for this challenge.
 * */
class SplitInteger {

    fun splitInteger(num: Int, parts: Int): List<Int> {
        val quotient = num / parts // Get the quotient of integer division
        val remainder = num % parts // Get the remainder
        val result = MutableList(parts) { quotient } // Create a mutable list of length 'parts' with each element equal to the quotient

        for (i in (parts - 1) downTo (parts - remainder)) {
            result[i]++ // Add one to the last 'remainder' elements to distribute the remainder
        }

        return result
    }
}
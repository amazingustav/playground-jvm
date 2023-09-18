package br.com.amazingapps.playground.math

/**
 * You are given a two-digit integer n. Return the sum of its digits.
 *
 * Input/Output
 * [execution time limit] 3 seconds (kt)
 *
 * Guaranteed constraints:
 * 10 ≤ n ≤ 99.
 * */
class MathPlays {

    /**
     * Given a two-digit integer n, return the sum of its digits.
     *
     * Guaranteed constraints:
     * 10 ≤ n ≤ 99.
     * */
    fun sumOfDigits(n: Int): Int {
        require(n in 10..99) { "n must be between 10 and 99 inclusive" }

        var sum = 0
        var num = n

        while (num != 0) {
            sum += num % 10
            num /= 10
        }

        return sum
    }

    /**
     * This code first converts the integer n to a string using the toString() function.
     * It then uses the fold() function on the string to iterate over each character and
     * accumulate the sum of their integer values.
     *
     * The fold() function takes an initial value of 0 for the accumulator, and a lambda function
     * that takes the current value of accumulator and the current, converts current to an integer using toInt(),
     * and adds it to accumulator. The result of this lambda function becomes the new value of accumulator for the next iteration.
     * */
    fun sumOfDigitsAlternative(n: Int): Int = n.toString().fold(0) { accumulator, current ->
        accumulator + current.toString().toInt()
    }

    /**
     * Given an array of positive integers numbers, calculate how many of its elements
     * have an even number of digits.
     *
     * Guaranteed constraints:
     * 1 ≤ numbers.length ≤ 1000.
     **/
    fun evenNumberOfDigits(numbers: MutableList<Int>): Int {
        require(numbers.size in 1..1000) { "numbers should contain between 1 and 1000 elements" }

        var count = 0

        for (num in numbers) {
            val digits = num.toString().length
            if (digits % 2 == 0) count++
        }

        return count
    }

    /**
     * For an array nums and an integer t (0 ≤ t < nums.length), let's define a cyclic t-shift operation
     * as carrying t elements from the beginning of the array to the end.
     *
     * For example, applying cyclic t-shift to array nums having values
     * [nums[0], nums[1], nums[2], ....., nums[n - 1]], where n is the length of the nums:
     * - For t = 0, the cyclic 0-shift will be [nums[0], nums[1], nums[2], ..., nums[n - 1]]
     * - For t = 1, the cyclic 1-shift will be [nums[1], nums[2], ..., nums[n - 1], nums[0]]
     * - For t = 2, the cyclic 2-shift will be [nums[2], ..., nums[n - 1], nums[0], nums[1]]
     * - ...
     * - For t = n - 1, the cyclic (n - 1)-shift will be [nums[n - 1], nums[0], nums[1], nums[2], ..., nums[n - 2]]
     *
     * Given an array of integers nums, find such t (0 ≤ t < nums.length) that cyclic t-shift operation turns nums
     * into a sorted array [1, 2, ..., nums.length]. If there is no such t, return -1.
     * */
    fun solution(nums: MutableList<Int>): Int {
        require(nums.size in 3 .. 100) { "numbers inside the list should be between 3 and 100" }

        val sorted = nums.sorted()

        for (number in 0 until nums.size) {
            val shifted = nums.subList(number, nums.size) + nums.subList(0, number)

            if (shifted == sorted) return number
        }

        return -1
    }

}

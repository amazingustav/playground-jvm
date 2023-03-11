package br.com.amazingapps.playground

/**
 * Write a function:
 * fun solution(A: IntArray): Int
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
class SmallestPositiveInt {

    fun solution(a: IntArray): Int {
        var previous = a.minOf { it }

        a.sorted().forEach {
            if (it == previous + 1) {
                previous = it
            } else if (it > 0 && it != previous) {
                return previous + 1
            }
        }

        return if (previous < 0) 1 else previous + 1
    }
}

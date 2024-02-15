package br.com.amazingapps.playground.integers

/**
 * Given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * */
class SmallestPositive {

    fun solution(numbers: IntArray): Int {
        val seen = hashSetOf<Int>()

        numbers.forEach { if (it > 0) seen.add(it) }

        for (i in 1..numbers.size) {
            if (!seen.contains(i)) return i
        }

        return numbers.size + 1
    }
}
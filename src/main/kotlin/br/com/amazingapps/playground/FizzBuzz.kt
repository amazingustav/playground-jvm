package br.com.amazingapps.playground

/**
 * Given a number, it must return a list with N string elements. Each element represents a number that will be
 * validated its multiple:
 *
 * When a number is multiple of 3, print "Fizz".
 * When it is multiple of 5, print "Buzz".
 * When it is multiple of both, print "FizzBuzz".
 * WHen it is not multiple of them, print the number.
 *
 * E.g. 5
 * returns {"1", "2", "Fizz", "4", "Buzz"}
 * */
class FizzBuzz {

    fun resolve(n: Int): List<String> {
        val result = mutableListOf<String>()

        for (i in 1..n) {
            val representation = when {
                i % 5 == 0 && i % 3 == 0 -> "FizzBuzz"
                i % 3 == 0 -> "Fizz"
                i % 5 == 0 -> "Buzz"
                else -> "$i"
            }

            result.add(representation)
        }

        return result
    }
}

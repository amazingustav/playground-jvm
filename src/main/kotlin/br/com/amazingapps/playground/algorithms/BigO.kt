package br.com.amazingapps.playground.algorithms

class BigO {

    /**
     * O(1) - Constant Time
     * The execution time of an algorithm is constant, regardless of the input size.
     **/
    fun printListContent(list: List<Int>): Int {
        if (list.isNotEmpty()) {
            return list[0]
        }

        throw Exception("List is empty")
    }

    /**
     * O(n) - Linear Time
     * The execution time of an algorithm is directly proportional to the input size.
     **/
    fun findValueInList(list: List<Int>, value: Int): Boolean {
        for (item in list) {
            if (item == value) {
                return true
            }
        }
        return false
    }

    /**
     * O(n^2) - Quadratic Time
     * The execution time of an algorithm is directly proportional to the square of the input size.
     **/
    fun bubbleSort(list: List<Int>): List<Int> {
        val sortedList = list.toMutableList()

        for (i in 0 until sortedList.size) {
            for (j in 0 until sortedList.size - 1) {
                if (sortedList[j] > sortedList[j + 1]) {
                    val temp = sortedList[j]
                    sortedList[j] = sortedList[j + 1]
                    sortedList[j + 1] = temp
                }
            }
        }

        return sortedList
    }

    /**
     * O(log n) - Logarithmic Time
     * The execution time of an algorithm is proportional to the logarithm of the input size.
     **/
    fun binarySearch(list: List<Int>, value: Int): Boolean {
        var low = 0
        var high = list.size - 1

        while (low <= high) {
            val mid = (low + high) / 2
            val guess = list[mid]

            if (guess == value) {
                return true
            }

            if (guess > value) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }

        return false
    }
}
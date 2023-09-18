package br.com.amazingapps.playground.strings

/**
 * Background
 * You've started work as a Morse code translator. Unfortunately some of the signals aren't as distinguishable as
 * others and there are times where a . seems indistinguishable from -. In these cases you write down a ? so that
 * you can figure out what all the possibilities of that letter for that word are later.
 *
 * Task
 * Write a function `possibilities` which will take a string `signals` and return an array of possible characters
 * that the Morse code signals could represent.
 *
 * The `signals` parameter contains the Morse code signals that needs to be parsed.
 * The may contain one or more unknown signals (?).
 *
 * The returned array or list contains the possible letters for the given group of signals.
 * These letters will always be ordered from how they appear on the chart, from left to right.
 *
 * There will be no more than 3 characters within `signals` and 0 - 3 unknown signals may be given.
 *
 * Examples
 * possibilities(".")   -> ["E"]
 * possibilities("-")   -> ["T"]
 * possibilities("-.")  -> ["N"]
 * possibilities("...") -> ["S"]
 * possibilities("..-") -> ["U"]
 * possibilities("?")   -> ["E", "T"]
 * possibilities(".?")  -> ["I", "A"]
 * possibilities("?-?") -> ["R", "W", "G", "O"]
 * */
class MorseCode {

    fun possibilities(signals: String): List<String> {
        val morseMap = mapOf(
                ".-" to "A", "-..." to "B", "-.-." to "C", "-.." to "D",
                "." to "E", "..-." to "F", "--." to "G", "...." to "H",
                ".." to "I", ".---" to "J", "-.-" to "K", ".-.." to "L",
                "--" to "M", "-." to "N", "---" to "O", ".--." to "P",
                "--.-" to "Q", ".-." to "R", "..." to "S", "-" to "T",
                "..-" to "U", "...-" to "V", ".--" to "W", "-..-" to "X",
                "-.--" to "Y", "--.." to "Z"
        )

        val results = mutableListOf<String>()

        fun generatePossibilities(signals: String, index: Int, current: String) {
            if (index >= signals.length) {
                if (morseMap.contains(current)) {
                    results.add(morseMap[current]!!)
                }
                return
            }

            when (signals[index]) {
                '.' -> generatePossibilities(signals, index + 1, "$current.")
                '-' -> generatePossibilities(signals, index + 1, "$current-")
                '?' -> {
                    generatePossibilities(signals, index + 1, "$current.")
                    generatePossibilities(signals, index + 1, "$current-")
                }
            }
        }

        generatePossibilities(signals, 0, "")

        return results
    }
}
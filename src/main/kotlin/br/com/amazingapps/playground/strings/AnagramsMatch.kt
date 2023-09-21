package br.com.amazingapps.playground.strings

import java.util.*

/**
 * Given a file of words and an input word to search for, implement a search on the file of words that returns
 * all words which contain the same letters the same number of times as the input word.
 * In other words, return all the anagrams of the input word found in the file.
 *
 * Ex: dictionary, testing, tes, test, estt, esst, Test, TTes, text, extt, tex, ext
 * Input: test
 * Output:test, estt, Test, TTes
 * */
class AnagramsMatch {

    fun main() {
        val inputWord = "test" // Replace with your input word
        val wordList = listOf(
            "dictionary", "testing", "tes", "test", "estt", "esst",
            "Test", "TTes", "text", "extt", "tex", "ext"
        ) // Replace with your list of words

        val anagrams = findAnagrams(wordList, inputWord)

        println("Anagrams of '$inputWord' found in the list:")
        anagrams.forEach { println(it) }
    }

    private fun findAnagrams(wordList: List<String>, inputWord: String): List<String> {
        val sortedInputWord = inputWord.stringfy()
        val anagramGroups = mutableMapOf<String, MutableList<String>>()

        wordList.forEach { word ->
            val sortedWord = word.stringfy()
            val group = anagramGroups.getOrPut(sortedWord) { mutableListOf() }
            group.add(word)
        }

        return anagramGroups[sortedInputWord] ?: emptyList()
    }

    /**
     * Extension function to sort a string alphabetically, unconsidered case.
     * */
    private fun String.stringfy(): String {
        return this.lowercase(Locale.getDefault()).toCharArray().sorted().joinToString("")
    }
}
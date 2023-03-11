package br.com.amazingapps.playground

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MorseCodeTest {

    private val morseCode: MorseCode = MorseCode()

    @Test
    fun testBasicCases() {
        kotlin.test.assertEquals(arrayListOf("E"), morseCode.possibilities("."))
        kotlin.test.assertEquals(arrayListOf("A"), morseCode.possibilities(".-"))
    }

    @Test
    fun aWordWithASingleUnknownSignal() {
        kotlin.test.assertEquals(arrayListOf("E", "T"), morseCode.possibilities("?"))
        kotlin.test.assertEquals(arrayListOf("I", "N"), morseCode.possibilities("?."))
        kotlin.test.assertEquals(arrayListOf("I", "A"), morseCode.possibilities(".?"))
    }
}
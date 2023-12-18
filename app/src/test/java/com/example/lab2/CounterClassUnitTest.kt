package com.example.lab2

import org.junit.Test

import org.junit.Assert.*
class ExampleUnitTest {

    @Test
    fun countingWordsTest()
    {
        val textCounter = Counter()

        val givenString = "test test test"

        val expectedString = "3"
        val actualInt = textCounter.countWords(givenString)
        val actualString = actualInt.toString()
        assertEquals(expectedString, actualString)
    }

    @Test
    fun countingCharactersTest()
    {
        val textCounter = Counter()

        val givenString = "test test"

        val expectedString = "9"
        val actualInt = textCounter.countCharacters(givenString)
        val actualString = actualInt.toString()
        assertEquals(expectedString, actualString)
    }
}
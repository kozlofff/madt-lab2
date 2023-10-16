package com.example.lab2

class Counter {
    fun countWords(text: String): Int {
        val words = text.split("[ ,.]+".toRegex())
        return words.size
    }

    fun countCharacters(text: String): Int {
        return text.length
    }
}

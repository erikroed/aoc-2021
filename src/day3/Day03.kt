package day3

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val length = input.first().length - 1
        var gammaRate = ""
        var epsilonRate = ""

        for (index in 0..length) {
            var zeroBits = 0
            var oneBits = 0
            input.forEach {
                val value = it[index].toString().toInt()
                if (value == 0) zeroBits++ else oneBits++
            }

            val gammaBit = if (zeroBits > oneBits) "0" else "1"
            val epsilonBit = if (zeroBits > oneBits) "1" else "0"

            gammaRate += gammaBit
            epsilonRate += epsilonBit
        }

        val gammaDecimal = gammaRate.toInt(2)
        val epsilonDecimal = epsilonRate.toInt(2)

        return gammaDecimal * epsilonDecimal
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day3/Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 12)

    val input = readInput("day3/Day03")
    println(part1(input))
    println(part2(input))
}

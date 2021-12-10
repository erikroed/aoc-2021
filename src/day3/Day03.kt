package day3

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val colums = input[0].indices

        val gammaRate = buildString {
            for (colum in colums) {
                val (zeroes, ones) = input.countBitsInColumn(colum)
                val commonBit = if (zeroes > ones) "0" else "1"
                append(commonBit)
            }
        }

        val epsilonRate = gammaRate.invertBinaryString()
        return gammaRate.toInt(2) * epsilonRate.toInt(2)
    }

    fun part2(input: List<String>): Int {
        fun oxyRating(): String {
            val columns = input[0].indices
            var candidates = input
            for (column in columns) {
                val (zeroes, ones) = candidates.countBitsInColumn(column)
                val mostCommon = if (zeroes > ones) '0' else '1'
                candidates = candidates.filter { it[column] == mostCommon }
                if (candidates.size == 1) break
            }

            return candidates.single()
        }

        fun co2Rating(): String {
            val columns = input[0].indices
            var candidates = input
            for (column in columns) {
                val (zeroes, ones) = candidates.countBitsInColumn(column)
                val mostCommon = if (zeroes > ones) '0' else '1'
                candidates = candidates.filter { it[column] != mostCommon }
                if (candidates.size == 1) break
            }

            return candidates.single()
        }

        return oxyRating().toInt(2) * co2Rating().toInt(2)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day3/Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("day3/Day03")
    println(part1(input))
    println(part2(input))
}

private fun List<String>.countBitsInColumn(column: Int): BitCount {
    var zeroes = 0
    var ones = 0

    for (line in this) {
        if (line[column] == '0') zeroes++ else ones++
    }

    return BitCount(zeroes, ones)
}

private fun String.invertBinaryString() = this.asIterable().joinToString("") { if (it == '0') "1" else "0" }

data class BitCount(val zeroes: Int, val ones: Int)

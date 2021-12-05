package day2

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var horizontal = 0
        var depth = 0

        input.forEach {
            val operation = it.substringBefore(" ").lowercase()
            val value = it.substringAfter(" ").toInt()

            when (operation) {
                "forward" -> horizontal += value
                "down" -> depth += value
                "up" -> depth -= value
            }
        }

        return horizontal * depth
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day2/Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 6)

    val input = readInput("day2/Day02")
    println(part1(input))
    println(part2(input))
}

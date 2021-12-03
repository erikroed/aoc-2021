fun main() {
    fun part1(input: List<String>): Int {
        var hit = 0

        input.forEachIndexed { index, element ->
            if (index == 0) return@forEachIndexed

            val previousNumber = input.elementAt(index.minus(1)).toInt()
            val currentNumber = element.toInt()
            if (currentNumber > previousNumber) {
                hit++
            }
        }

        return hit
    }

    fun part2(input: List<String>): Int {
        var hit = 0

        input.forEachIndexed { index, _ ->
            val toPosition = index.plus(3)
            val secondFromPosition = index.plus(1)
            val secondToPosition = toPosition.plus(1)

            val validPosition =
                listOf(index, toPosition, secondFromPosition, secondToPosition).all { it <= input.size }

            if (validPosition) {
                val firstChunk = input.subList(index, toPosition).sumOf { it.toInt() }
                val secondChunk = input.subList((index + 1), (toPosition + 1)).sumOf { it.toInt() }

                if (secondChunk > firstChunk) {
                    hit++
                }
            }

        }

        return hit
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

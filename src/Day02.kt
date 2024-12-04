import kotlin.math.abs

fun main() {
    fun toList(line: String) = line.split(" ").map { it.toInt() }

    fun test(list: List<Int>): Boolean {
        val direction = list[0] < list[1]

        for (i in 0 until list.size - 1) {
            if (list[i] == list[i + 1]) {
                return false
            }
            if (direction != list[i] < list[i + 1]) {
                return false
            }
            if (abs(list[i] - list[i + 1]) > 3) {
                return false
            }
        }

        return true
    }

    fun part1(input: List<String>): Long {
        return input.stream()
            .map { toList(it) }
            .filter { test(it) }
            .count()
    }

    fun test2(list: List<Int>): Boolean {
        for (i in list.indices) {
            val copy = list.toMutableList()
            copy.removeAt(i)
            if (test(copy)) {
                return true
            }
        }
        return false
    }

    fun part2(input: List<String>): Long {
        return input.stream()
            .map { toList(it) }
            .filter { test2(it) }
            .count()
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

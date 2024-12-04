import kotlin.math.abs

fun main() {
    fun parse(input: List<String>): Pair<MutableList<Int>, MutableList<Int>> {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        for (line in input) {
            val ints = line.split("   ").map { it.toInt() }
            left.add(ints[0])
            right.add(ints[1])
        }
        return Pair(left, right)
    }

    fun part1(input: List<String>): Int {

        val (left, right) = parse(input)
        left.sort()
        right.sort()
        return left.zip(right).sumOf { (l ,r) -> abs( l - r) }
    }

    fun part2(input: List<String>): Int {
        val (left, right) = parse(input)
        return left.sumOf { l -> l * right.count { r -> r == l } }
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

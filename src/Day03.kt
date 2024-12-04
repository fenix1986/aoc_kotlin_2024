fun main() {
    fun mul(text: String) : Int {
        val numbers = text.split("(", ",", ")")
        return numbers[1].toInt() * numbers[2].toInt()
    }

    fun part1(input: List<String>): Int {
        val fullInput = input.joinToString { it }
        val regex = """mul\([0-9]{1,3},[0-9]{1,3}\)""".toRegex()
        val matches = regex.findAll(fullInput)
        return matches.sumOf { mul(it.value) }
    }

    fun part2(input: List<String>): Int {
        val fullInput = input.joinToString { it }
        val regex = """do\(\)|don't\(\)|mul\([0-9]{1,3},[0-9]{1,3}\)""".toRegex()
        val matches = regex.findAll(fullInput)

        var use = true
        var result = 0

        matches.forEach { match ->
            when (match.value) {
                "do()" -> use = true
                "don't()" -> use = false
                else -> if (use) result += mul(match.value)
            }
        }

        return result
    }

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}

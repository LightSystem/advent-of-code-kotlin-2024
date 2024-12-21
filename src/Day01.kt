import kotlin.math.abs

fun main() {
    val input = readInput("Day01")
    val (firstColumn, secondColumn) = input.map { line ->
        line.split("   ").let { (first, second) -> first.toInt() to second.toInt() }
    }.unzip()
    val part1Answer = firstColumn.sorted().zip(secondColumn.sorted()).sumOf { abs(it.first - it.second) }
    part1Answer.println()
    val frequency = secondColumn.groupingBy { it }.eachCount()
    val part2Answer = firstColumn.sumOf { it * frequency.getOrDefault(it, 0) }
    part2Answer.println()
}

import kotlin.math.abs

fun main() {
    fun isReportSafe(report: List<Int>): Boolean {
        var prev = report.first()
        val asc = report.take(2).let { (a, b) -> b > a }
        return report.drop(1).all { level ->
            val diff = abs(level - prev)
            (diff in 1..3 && ((asc && level > prev) || (!asc && level < prev))).also { prev = level }
        }
    }

    val input = readInput("Day02")
    val reports = input.map { line -> line.split(" ").map { it.toInt() } }
    val part1Answer = reports.count { isReportSafe(it) }
    part1Answer.println()
    val part2Answer = reports.count { report ->
        report.indices.any { index -> isReportSafe(report.toMutableList().apply { removeAt(index) }) }
    }
    part2Answer.println()
}
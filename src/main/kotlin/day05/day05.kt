package day05

import inputLines
import toIdRange

fun main() {
    println("Part 1: ${part1()}")
    println("Part 2: ${part2()}")
}

fun part1(name: String = "day05") = inputLines(name) { lines ->
    val (fresh: List<LongRange>, ids: List<Long>) = lines
        .filter { it.isNotBlank() }
        .partition { it.contains("-") }
        .let { (rawFresh, rawIds) ->
            rawFresh.map { it.toIdRange() } to rawIds.map { it.toLong() }
        }
    ids.count { id -> fresh.any { id in it } }
}

fun part2(name: String = "day05") = inputLines(name) { lines ->
    val ranges = buildList {
        for (line in lines) {
            if (line.isBlank()) break
            add(line.toIdRange())
        }
    }

    ranges.sortedBy { it.first }.fold(emptyList<LongRange>()) { acc, next ->
        val prev = acc.lastOrNull() ?: return@fold listOf(next)

        when {
            next.first > prev.last.inc() -> acc.plusElement(next)
            next.last > prev.last -> acc.dropLast(1).plusElement(prev.first..next.last)
            else -> acc
        }
    }.sumOf { it.size }
}

val LongRange.size get() = (last - first + 1).coerceAtLeast(0)
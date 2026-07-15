package day03

import inputLines


fun main() {
  println("Part 1: ${part1()}")
  println("Part 2: ${part2()}")
}


fun part1(name: String = "day03") = inputLines(name) { lines ->
  lines.sumOf { line ->
    val result = mutableListOf<Int>()
    line.forEachIndexed { index, first ->
      line.drop(index + 1).forEach { second ->
        result.add("$first$second".toInt())
      }
    }
    result.max()
  }
}

fun part2(name: String = "day03") = inputLines(name) { it.sumOf(::calculate) }


fun calculate(input: String, length: Int = 12) = buildString {
  1.rangeTo(length).fold(0) { start, i ->
    val end = input.length - (length - i)
    val slice = input.slice(start until end)
    val (index, value) = slice.withIndex().maxBy { it.value }

    append(value)
    start + index.inc()
  }
}.toLong()



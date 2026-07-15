package day06

import input
import inputLines

var operators = mapOf<String, (ULong, ULong) -> ULong>(
  "+" to { a, b -> a + b },
  "*" to { a, b -> a * b }
)

val regex = Regex("\\s+")

fun main() {
  println("Part 1: ${part1()}")
  println("Part 2: ${part2()}")
}

fun part1(name: String = "day06"): ULong {
  val rows = inputLines(name) { lines ->
    lines.map { it.trim().split(regex) }.toList()
  }

  val data = rows.dropLast(1)
  val ops = rows.last()

  val results = ops.mapIndexed { i, rawOp ->
    val op = operators.getOrElse(rawOp) { error("Unknown operator $rawOp") }
    val values = data.map { it[i].toULong() }

    values.reduce(op)
  }

  return results.sum()
}

fun part2(name: String = "day06"): ULong {
  val lines = input(name).readLines()
  val ops = lines.last()
  val data = lines.dropLast(1)

  val results = mutableListOf<ULong>()

  ops.foldRightIndexed(emptyList<ULong>()) { i, raw, acc ->
    val number = data.numberAt(i) ?: return@foldRightIndexed acc

    acc.plusElement(number).let { acc ->
      when (raw) {
        '+' -> emptyList<ULong>().also { results.add(acc.sum()) }
        '*' -> emptyList<ULong>().also { results.add(acc.reduce(ULong::times)) }
        else -> acc
      }
    }


  }

  return results.sum()
}

fun List<String>.numberAt(index: Int) = map { it[index] }.joinToString("").trim().toULongOrNull()

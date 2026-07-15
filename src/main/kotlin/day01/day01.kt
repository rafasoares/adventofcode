package day01

import day07.part1
import day07.part2
import input
import kotlin.math.absoluteValue

fun main() {
  println("Part 1: ${part1()}")
  println("Part 2: ${part2()}")
}

private const val DIAL_SIZE = 100

fun part1(name: String = "day01") = input(name).useLines { lines ->
  lines.runningFold(50) { current, line ->
    val amount = line.toAmount()
    (current + amount).mod(DIAL_SIZE)
  }
    .count { it == 0 }
}

fun spin(dial: Int, amount: Int): Pair<Int, Int> {
  val value = dial + amount
  val zeroes = (value.absoluteValue / DIAL_SIZE)
    .let { if (dial != 0 && value <= 0) it + 1 else it }
  return value.mod(DIAL_SIZE) to zeroes
}

fun part2(name: String = "day01") = input(name).useLines { lines ->
  lines
    .map { it.toAmount() }
    .runningFold(50 to 0) { (dial, _), amount ->
      spin(dial, amount)
    }
    .sumOf { it.second }
}

fun String.toAmount(): Int {
  val direction = when (first()) {
    'L' -> -1
    else -> 1
  }

  return drop(1).toInt() * direction
}

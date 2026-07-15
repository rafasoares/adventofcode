package day02

import input
import toIdRanges
import kotlin.math.ceil

fun main() {
  println("Part 1: ${part1()}")
  println("Part 2: ${part2()}")
}

fun part1(name: String = "day02") = input(name).readText().toIdRanges().flatMap { ids ->
  ids.asSequence()
    .filter {
      val id = it.toString()
      if (id.length < 2) return@filter false

      val half = ceil(id.length / 2.0).toInt()
      val (first, second) = id.chunked(half)
      first == second
    }
}.sum()

fun part2(name: String = "day02") = input(name).readText().toIdRanges().flatMap { ids ->
  ids.asSequence()
    .filter { rawId ->
      val id = rawId.toString()
      val half = id.length / 2
      (1..half)
        .map { id.take(it) }
        .map { Regex("^($it)+$") }
        .any { it.matches(id) }
    }
}.sum()

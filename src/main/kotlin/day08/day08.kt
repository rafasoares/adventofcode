package day08

import inputLines

fun main() {
  println("Part 1: ${part1()}")
  println("Part 2: ${part2()}")
}

fun part1(name: String = "day08", maxConnections: Int = 1000, maxCircuits: Int = 3) = inputLines(name) { lines ->
  println()
  val positions = lines.map { it.toPosition() }.toList()
  val circuits = mutableListOf<Circuit>()
  positions.connections().sorted().take(maxConnections).forEach(circuits::connect)
  circuits.sortedDescending()
    .take(maxCircuits)
    .fold(1) { total, circuit -> total * circuit.size }
}

fun part2(name: String = "day08") = inputLines(name) { lines ->
  val positions = lines.map { it.toPosition() }.toList()
  val circuits = mutableListOf<Circuit>()
  val finalConnection = positions.connections().sorted().first {
    circuits.connect(it)
    circuits.singleOrNull()?.size == positions.size
  }
  finalConnection.distanceToWall()
}


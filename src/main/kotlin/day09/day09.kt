package day09

import inputLines

@Suppress("KotlinPrintToLogpoint")
fun main() {
  println("Part 1: ${part1()}")
  println("Part 2: ${part2()}")
}

fun part1(name: String = "day09") = inputLines(name) { lines ->
  val points = lines
    .map { line ->
      val (x, y) = line.split(",")
      Point(x.toInt(), y.toInt())
    }.toList()

  val rectangles = points.pairs()
    .map { (a, b) -> Rectangle(a, b) }

  rectangles.maxOf { it.area }
}

fun part2(name: String = "day09") = inputLines(name) { lines ->
  val points = lines
    .map { line ->
      val (x, y) = line.split(",")
      Point(x.toInt(), y.toInt())
    }
    .toList()

  val rectangles = points.pairs()
    .map { (a, b) -> Rectangle(a, b) }

  val shape = Polygon(points)

  rectangles
    .filter { it in shape }
    .maxOf { it.area }
}

fun <T> List<T>.pairs() = sequence {
  for ((i, a) in this@pairs.dropLast(1).withIndex()) {
    for (b in this@pairs.drop(i + 1)) {
      yield(a to b)
    }
  }
}

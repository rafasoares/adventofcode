package day04

import inputLines

fun main() {
  println("Part 1: ${part1()}")
  println("Part 2: ${part2()}")
}


data class Position(val x: Int, val y: Int) {
  operator fun plus(other: Position) = Position(x + other.x, y + other.y)

  override fun toString(): String = "($x,$y)"
}

val neighbors = (-1..1).flatMap { x -> (-1..1).map { y -> x by y } }
  .filterNot { it == 0 by 0 }
  .toSet()

infix fun Int.by(other: Int) = Position(this, other)

fun part1(name: String = "day04") = inputLines(name) { lines ->
  val grid = lines.toGrid()
  grid.asSequence()
    .filter { it.isPaper() }
    .map { (position, _) -> getNeighbors(position, grid).filter { it.isPaper() } }
    .count { it.size < 4 }
}

fun part2(name: String = "day04") = inputLines(name) { lines ->
  val grid = lines.toGrid()
  val removed = mutableListOf<Int>()

  while (true) {
    val canAccess = grid
      .asSequence()
      .filter { it.isPaper() }
      .filter { (position, _) -> grid.neighbors(position).count { it.isPaper() } < 4 }
      .toList()

    if (canAccess.none()) break
    removed.add(canAccess.count())

    canAccess.forEach { (position, _) -> grid[position] = '.' }
  }

  removed.sum()
}

fun Sequence<String>.toGrid(): MutableMap<Position, Char> =
  flatMapIndexed { y, line -> line.mapIndexed { x, char -> (x by y) to char } }.toMap() as MutableMap<Position, Char>

fun getNeighbors(position: Position, grid: Map<Position, Char>): List<Char> =
  neighbors
    .map { position + it }
    .mapNotNull { pos -> grid.entries.find { it.key == pos } }
    .map { it.value }

fun Map<Position, Char>.neighbors(position: Position) = getNeighbors(position, this)


fun Map.Entry<Position, Char>.isPaper() = value.isPaper()

fun Char.isPaper() = this == '@'

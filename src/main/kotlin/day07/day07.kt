package day07

import input
import inputLines

fun main() {
  println("Part 1: ${part1()}")
  println("Part 2: ${part2()}")
}

fun part1(name: String = "day07") = inputLines(name) { lines ->
  var count = 0
  val iter = lines.iterator()

  val first = iter.next()
  val starting = first.indexOf('S')

  val rest = iter.asSequence()

  rest.scan(setOf(starting)) { beams, line ->
    beams.fold(emptySet()) { acc, index ->
      when (line[index]) {
        '.' -> acc + index
        '^' -> acc + setOf(index.dec(), index.inc()).also { count++ }
        else -> error("Invalid char: ${line[index]} at index $index in $line")
      }
    }
  }.toList().count()
}

fun part2(name: String = "day07") = input(name).useLines { lines ->
  val iter = lines.iterator()

  val first = iter.next()
  val rest = iter.asSequence()

  val starting = first.indexOf('S')

  rest.fold(mapOf(starting to 1UL)) { positions, line ->
    buildMap {
      for ((position, count) in positions) {
        if (line[position] == '^') {
          setOrInc(position.dec(), count)
          setOrInc(position.inc(), count)
        } else {
          setOrInc(position, count)
        }
      }
    }
  }.values.sum()
}

fun <K> MutableMap<K, ULong>.setOrInc(key: K, value: ULong) = if (containsKey(key)) {
  this[key] = this[key]!! + value
} else {
  put(key, value)
}

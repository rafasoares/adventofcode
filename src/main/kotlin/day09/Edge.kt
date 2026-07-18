package day09

import kotlin.math.max
import kotlin.math.min

data class Edge(val from: Point, val to: Point) {
  val rangeX = from.x..to.x
  val rangeY = from.y..to.y

  val x = listOf(from.x, to.x)
  val y = listOf(from.y, to.y)

  val minX = min(from.x, to.x)
  val maxX = max(from.x, to.x)
  val minY = min(from.y, to.y)
  val maxY = max(from.y, to.y)

  operator fun contains(point: Point): Boolean {
    if (point.x in x && point.y in rangeY) return true
    if (point.y in y && point.x in rangeX) return true
    return false
  }
}

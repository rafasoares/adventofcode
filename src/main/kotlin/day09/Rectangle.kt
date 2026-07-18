package day09

import kotlin.math.max
import kotlin.math.min

data class Rectangle(val a: Point = Point(), val b: Point = Point()) {
  val x = min(a.x, b.x)
  val y = min(a.y, b.y)
  val maxX = max(a.x, b.x)
  val maxY = max(a.y, b.y)
  val width = (maxX - x).inc()
  val height = (maxY - y).inc()

  val rangeX = x..maxX
  val rangeY = y..maxY

  val area = width.toULong() * height.toULong()

  operator fun contains(point: Point) = point.x in rangeX && point.y in rangeY

  override fun toString() = "Rectangle[$a, $b, area=$area]"
}

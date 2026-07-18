package day09

data class Point(val x: Int = 0, val y: Int = 0) {
  override fun toString() = "Point[$x, $y]"

  operator fun minus(other: Point) = Point(x - other.x, y - other.y)
}

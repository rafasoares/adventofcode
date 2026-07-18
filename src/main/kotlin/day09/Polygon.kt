package day09

data class Polygon(val points: List<Point>) {
  val minX = points.minOf { it.x }
  val minY = points.minOf { it.y }
  val maxX = points.maxOf { it.x }
  val maxY = points.maxOf { it.y }

  val edges = points
    .windowed(2, 1)
    .map { (a, b) -> Edge(a, b) }
    .plusElement(Edge(points.last(), points.first()))

  operator fun contains(point: Point) = edges.any { point in it }

  operator fun contains(rectangle: Rectangle) = edges.all { edge ->
    val left = rectangle.maxX <= edge.minX
    val right = rectangle.x >= edge.maxX
    val above = rectangle.maxY <= edge.minY
    val below = rectangle.y >= edge.maxY

    left || right || above || below
  }

  override fun toString() = "Polygon[$minX, $minY, $maxX, $maxY]"
}

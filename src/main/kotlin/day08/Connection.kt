package day08

data class Connection(val a: Position, val b: Position) : Comparable<Connection> {
  val positions = setOf(a, b)
  val length = a distanceTo b

  override fun compareTo(other: Connection) = length.compareTo(other.length)
  override fun toString() = "Connection($a to $b length=$length)"

  fun distanceToWall() = a.x.toLong() * b.x.toLong()
}

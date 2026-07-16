package day08

import kotlin.math.absoluteValue

data class Position(val x: Int, val y: Int, val z: Int) {
  override fun toString() = "($x,$y,$z)"

  infix fun connectTo(other: Position) = Connection(this, other)

  infix fun distanceTo(other: Position): Long {
    val dx = (x - other.x).toLong()
    val dy = (y - other.y).toLong()
    val dz = (z - other.z).toLong()

    return (dx * dx + dy * dy + dz * dz).absoluteValue
  }

  operator fun times(other: Position) = (x * other.x) + (y * other.y) + (z * other.z)
}

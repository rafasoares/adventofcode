package day08

val ids = (0U..UInt.MAX_VALUE).asSequence().iterator()

@Suppress("JavaDefaultMethodsNotOverriddenByDelegation")

class Circuit(vararg starting: Position) : MutableSet<Position> by starting.toMutableSet(), Comparable<Circuit> {
  val id = ids.next()
  operator fun contains(connection: Connection) = connection.positions.any { it in this }
  override fun toString() = "Circuit #$id (${toList().joinToString(", ")})"
  override fun compareTo(other: Circuit) = size.compareTo(other.size)
}

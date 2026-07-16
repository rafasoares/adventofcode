package day08

fun String.toPosition(): Position {
  val (x, y, z) = split(",").map(String::toInt)
  return Position(x, y, z)
}

fun List<Position>.connections() = sequence {
  for (i in 0 until size - 1) {
    for (j in i + 1 until size) {
      yield(get(i) connectTo get(j))
    }
  }
}

fun MutableList<Circuit>.connect(connection: Connection) {
  when (val matches = filter { circuit -> connection in circuit }) {
    emptyList<Circuit>() -> add(Circuit(connection.a, connection.b))
    else -> when (matches.size) {
      1 -> matches.single().addAll(connection.positions)
      else -> {
        val (first, second) = matches
        first.addAll(second)
        remove(second)
      }
    }
  }
}

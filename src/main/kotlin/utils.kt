fun input(name: String) =
  requireNotNull(Thread.currentThread().contextClassLoader.getResourceAsStream("inputs/$name.txt"))
  {
    "Missing input file for day $name.txt"
  }.bufferedReader()

fun <T> inputLines(name: String, block: (Sequence<String>) -> T) = input(name).useLines(block = block)

fun debug(vararg values: Pair<String, Any?>) {
  val formatted = values.joinToString(separator = ", ") { (key, value) ->
    val formattedValue = when (value) {
      is Iterable<*> -> value.joinToString(separator = "")
      else -> value.toString()
    }
    "$key=$formattedValue"
  }

  println(formatted)
}

fun String.toIdRange() = split("-").map { it.trim().toLong() }.let { (start, end) -> start..end }
fun String.toIdRanges() = splitToSequence(",").map { it.toIdRange() }

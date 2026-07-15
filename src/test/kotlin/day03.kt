import day03.calculate
import day03.part1
import day03.part2
import de.infix.testBalloon.framework.core.testSuite
import kotlin.test.assertEquals

val day03 by testSuite {
  test("Day 3, part 1") {
    assertEquals(357, part1())
  }

  test("Day 3, part 2") {
    assertEquals(3121910778619, part2())
  }

  mapOf(
    "987654321111111" to 987654321111,
    "811111111111119" to 811111111119,
    "234234234234278" to 434234234278,
    "818181911112111" to 888911112111
  ).forEach { (input, output) ->
    test("calculate($input) = $output") {
      assertEquals(output, calculate(input))
    }
  }
}


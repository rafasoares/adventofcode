import day04.part1
import day04.part2
import de.infix.testBalloon.framework.core.testSuite
import kotlin.test.assertEquals

val day04 by testSuite {
  test("Day day04, part 1") {
    assertEquals(13, part1())
  }

  test("Day day04, part 2") {
    assertEquals(43, part2())
  }
}


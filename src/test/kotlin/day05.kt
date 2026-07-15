import day05.part1
import day05.part2
import de.infix.testBalloon.framework.core.testSuite
import kotlin.test.assertEquals

val day05 by testSuite {
  test("Day day05, part 1") {
    assertEquals(3, part1())
  }

  test("Day day05, part 2") {
    assertEquals(14, part2())
  }

}


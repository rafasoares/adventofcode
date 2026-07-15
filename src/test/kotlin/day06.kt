import day06.part1
import day06.part2
import de.infix.testBalloon.framework.core.testSuite
import kotlin.test.assertEquals

val day06 by testSuite {
  test("Day day06, part 1") {
    assertEquals(4277556U, part1())
  }

  test("Day day06, part 2") {
    assertEquals(3263827U, part2())
  }

}


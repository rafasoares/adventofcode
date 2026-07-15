import day07.part1
import day07.part2
import de.infix.testBalloon.framework.core.testSuite
import kotlin.test.assertEquals

val day07 by testSuite {
  test("Day day07, part 1") {
    assertEquals(21, part1())
  }

  test("Day day07, part 2") {
    assertEquals(40UL, part2())
  }

}


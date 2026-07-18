import day09.part1
import day09.part2
import de.infix.testBalloon.framework.core.testSuite
import kotlin.test.assertEquals

val day09 by testSuite {
  test("Day day09, part 1") {
    assertEquals(50UL, part1())
  }

  test("Day day09, part 2") {
    assertEquals(24UL, part2())
  }

}


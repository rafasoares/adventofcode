import day08.part1
import day08.part2
import de.infix.testBalloon.framework.core.testSuite
import kotlin.test.assertEquals

val day08 by testSuite {
  test("Day day08, part 1") {
    assertEquals(40, part1(maxConnections = 10))
  }

  test("Day day08, part 2") {
    assertEquals(25272L, part2())
  }

}


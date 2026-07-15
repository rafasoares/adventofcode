import day02.part1
import day02.part2
import de.infix.testBalloon.framework.core.testSuite
import org.junit.jupiter.api.Assertions.assertEquals

val day02 by testSuite {
  test("Day 2, part 1") {
    assertEquals(1227775554, part1())
  }

  test("Day 2, part 2") {
    assertEquals(4174379265, part2())
  }
}

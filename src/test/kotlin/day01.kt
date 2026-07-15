import day01.part1
import day01.part2
import day01.spin
import de.infix.testBalloon.framework.core.testSuite
import kotlin.test.assertEquals


val day01 by testSuite {
  test("Day 1, part 1") {
    assertEquals(3, part1())
  }
  test("Day 1, part 2") {
    assertEquals(6, part2())
  }
  data class TestCase(val dial: Int, val amount: Int, val output: Pair<Int, Int>)

  testSuite("spin") {
    val input = sequenceOf(
      TestCase(50, 1000, 50 to 10),
      TestCase(50, -1000, 50 to 10),
      TestCase(50, -68, 82 to 1),
      TestCase(0, 120, 20 to 1),
      TestCase(0, -120, 80 to 1),
      TestCase(90, 130, 20 to 2),
      TestCase(10, -130, 80 to 2),
      TestCase(60, -160, 0 to 2),
      TestCase(60, 140, 0 to 2),
      TestCase(0, 200, 0 to 2),
      TestCase(0, -200, 0 to 2),
    )

    input.forEach { (dial, amount, output) ->
      test("spin($dial, $amount) = $output") {
        assertEquals(output, spin(dial, amount))
      }
    }
  }
}


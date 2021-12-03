package aoc21

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day2Test: FunSpec({
    val sample = """
            forward 5
            down 5
            forward 8
            up 3
            down 8
            forward 2
       """.trimIndent()

   test("calculate position test") {

       val result = Day2.calculatePos(sample)
       result shouldBe 150
   }

    test("calculate solution one") {
        val input = this.javaClass.getResource("/day_02_1.txt").readText().trim()
        val result = Day2.calculatePos(input)
        result shouldBe 1947824
    }

    test("calculate position with aim test") {
        val result = Day2.calculatePosWithAim(sample)
        result shouldBe 900
    }

    test("calculate solution two") {
        val input = this.javaClass.getResource("/day_02_1.txt").readText().trim()
        val result = Day2.calculatePosWithAim(input)
        result shouldBe 1813062561
    }
})
package aoc21

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day1Test: FunSpec({
    val sample = """
           199
           200
           208
           210
           200
           207
           240
           269
           260
           263
       """.trimIndent()

   test("calculate increases test") {

       val result = Day1.calculateIncreases(sample)
       result shouldBe 7
   }

    test("calculate solution one") {
        val input = this.javaClass.getResource("/day_01_1.txt").readText().trim()
        val result = Day1.calculateIncreases(input)
        result shouldBe 1154
    }

    test("calculate windowed increases test") {
        val result = Day1.calculateIncreasesWindowed(sample)
        result shouldBe 5
    }

    test("calculate solution two") {
        val input = this.javaClass.getResource("/day_01_1.txt").readText().trim()
        val result = Day1.calculateIncreasesWindowed(input)
        result shouldBe 1127
    }
})
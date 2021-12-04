package aoc21

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day3Test: FunSpec({
    val sample = """
            00100
            11110
            10110
            10111
            10101
            01111
            00111
            11100
            10000
            11001
            00010
            01010
       """.trimIndent()

   test("calculate power consumption test") {
       val result = Day3.calculatePowerConsumption(sample)
       result shouldBe 198
   }

    test("calculate power consumption solution one") {
        val input = this.javaClass.getResource("/day_03_1.txt").readText().trim()
        val result = Day3.calculatePowerConsumption(input)
        result shouldBe 3985686
    }

    test("calculate life support test") {
        val result = Day3.calculateLifeSupport(sample)
        result shouldBe 230
    }

    test("calculate power consumption solution two") {
        val input = this.javaClass.getResource("/day_03_1.txt").readText().trim()
        val result = Day3.calculateLifeSupport(input)
        result shouldBe 2555739
    }
})
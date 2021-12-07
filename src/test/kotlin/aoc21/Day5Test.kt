package aoc21

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day5Test : FunSpec({
    val sample = """
        0,9 -> 5,9
        8,0 -> 0,8
        9,4 -> 3,4
        2,2 -> 2,1
        7,0 -> 7,4
        6,4 -> 2,0
        0,9 -> 2,9
        3,4 -> 1,4
        0,0 -> 8,8
        5,5 -> 8,2
       """.trimIndent()

    test("calculate overlap count test") {
        val result = Day5.calculateOverlapCount(sample)
        result shouldBe 5
    }

    test("calculate overlap count solution one") {
        val input = this.javaClass.getResource("/day_05_1.txt").readText().trim()
        val result = Day5.calculateOverlapCount(input)
        result shouldBe 6856
    }

    test("calculate overlap count with diagonals test") {
        val result = Day5.calculateOverlapCount(sample, true)
        result shouldBe 12
    }

    test("calculate overlap count solution two") {
        val input = this.javaClass.getResource("/day_05_1.txt").readText().trim()
        val result = Day5.calculateOverlapCount(input, true)
        result shouldBe 20666
    }

})
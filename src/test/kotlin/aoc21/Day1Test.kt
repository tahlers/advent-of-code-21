package aoc21

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day1Test: FunSpec({
   test("this is a preparation onlye") {
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
       val result = Day1.calculateIncreases(sample)
       result shouldBe 7
   }
})
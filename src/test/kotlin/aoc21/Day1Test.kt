package aoc21

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day1Test: FunSpec({
   test("this is a preparation onlye") {
       val sample = "hello world"
       val result = Day1.calculateTODO(sample)
       result shouldBe sample
   }
})
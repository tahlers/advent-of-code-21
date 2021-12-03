package aoc21

object Day1 {

    fun calculateIncreases(input: String): Int {
        val numbers = input.trim()
            .lines()
            .map { it.toInt() }
        return countIncreases(Int.MAX_VALUE, 0, numbers)
    }

    private fun countIncreases(numberBefore: Int, currentCount: Int, numbers: List<Int>): Int {
        if (numbers.isEmpty()) {
            return currentCount
        } else {
            val head = numbers[0]
            val newCount = if (head > numberBefore) currentCount + 1  else currentCount
            return countIncreases(head, newCount, numbers.drop(1))
        }
    }
}
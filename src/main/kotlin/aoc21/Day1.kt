package aoc21

object Day1 {

    fun calculateIncreases(input: String): Int {
        val numbers = input.trim()
            .lines()
            .map { it.toInt() }
        return countIncreases(Int.MAX_VALUE, 0, numbers)
    }

    fun calculateIncreasesWindowed(input: String): Int {
        val numbers = input.trim()
            .lines()
            .map { it.toInt() }
        val windowed = numbers.windowed(3)
        return countIncreasesWindowed(Int.MAX_VALUE, 0, windowed)
    }

    private tailrec fun countIncreases(numberBefore: Int, currentCount: Int, numbers: List<Int>): Int {
        if (numbers.isEmpty()) {
            return currentCount
        } else {
            val head = numbers[0]
            val newCount = if (head > numberBefore) currentCount + 1  else currentCount
            return countIncreases(head, newCount, numbers.drop(1))
        }
    }

    private tailrec fun countIncreasesWindowed(numberBefore: Int, currentCount: Int,  windowed: List<List<Int>>): Int {
        if (windowed.isEmpty()) {
            return currentCount
        } else {
            val headWindowSum = windowed[0].sum()
            val newCount = if (headWindowSum > numberBefore) currentCount + 1  else currentCount
            return countIncreasesWindowed(headWindowSum, newCount, windowed.drop(1))
        }
    }
}
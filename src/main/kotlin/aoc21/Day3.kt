package aoc21

object Day3 {

    fun calculatePowerConsumption(input: String): Int {
        val gamma = toGamma(input)
        val epsilon = flipBitsInString(Integer.toBinaryString(gamma)).toInt(2)
        return gamma * epsilon
    }

    fun calculateLifeSupport(input: String): Int {
        val lines = input.trim().lines()
        val oxygenRating = filterLines(lines, true)
        val scrubberRating = filterLines(lines, false)
        return oxygenRating * scrubberRating
    }

    private fun toGamma(input: String): Int  {
        val lines = input.trim().lines()
        val threshold = lines.size / 2
        val bitSums = lines
            .map { line ->
                line.map { it.digitToInt() }
            }
            .reduce(::sumList)
        val gammaStr = bitSums
            .map { if (it > threshold) '1' else '0' }
            .joinToString("")
       return gammaStr.toInt(2)
    }

    private tailrec fun filterLines(lines: List<String>, searchGreatest: Boolean, index: Int = 0): Int {
        return if (lines.size == 1) {
            lines[0].toInt(2)
        } else {
            val (zeroes, ones) = lines.partition { line -> line[index] == '0' }
            val filterFor: List<String> = if (searchGreatest) {
                if (ones.size >= zeroes.size) ones else zeroes
            } else {
                if (zeroes.size <= ones.size) zeroes else ones
            }
            filterLines(filterFor, searchGreatest, index + 1)
        }
    }

    private fun sumList(a: List<Int>, b: List<Int>): List<Int> = a.mapIndexed { index, num -> num + b[index] }
    private fun flipBitsInString(input: String): String {
        return input
            .map { if (it == '0') '1' else '0' }
            .joinToString("")
    }
}
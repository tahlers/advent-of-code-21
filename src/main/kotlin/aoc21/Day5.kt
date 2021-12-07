package aoc21

import kotlin.math.sign

object Day5 {

    data class Pos(val x: Int, val y: Int)

    fun calculateOverlapCount(input: String, considerDiagonals: Boolean = false): Int {
        val lines = input.trim().lines()
        val linePoints = lines
            .map(::parseStartEnd)
            .filter { considerDiagonals || (it.first.x == it.second.x || it.first.y == it.second.y) }
            .flatMap { generatePosInLine(it.first, it.second) }
        val overlapMap = linePoints.groupingBy { it }.eachCount()
        return overlapMap.filter { it.value > 1 }.size
    }

    private fun parseStartEnd(line: String): Pair<Pos, Pos> {
        val (first, second) = line.trim().split(" -> ")
        val (firstX, firstY) = first.split(",")
        val (secondX, secondY) = second.split(",")
        return Pair(
            Pos(firstX.toInt(), firstY.toInt()),
            Pos(secondX.toInt(), secondY.toInt())
        )
    }

    private fun generatePosInLine(start: Pos, end: Pos): List<Pos> {
        val deltaX = (end.x - start.x).sign
        val deltaY = (end.y - start.y).sign
        val linePositions = generateSequence(start) { pos ->
            if (pos == end) null else Pos(pos.x + deltaX, pos.y + deltaY)
        }
        return linePositions.toList()
    }
}
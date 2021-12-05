package aoc21

object Day4 {

    data class Pos(val x: Int, val y: Int)

    data class Board(val numbers: Map<Pos, Int>, val hits: Set<Pos> = setOf()) {
        fun drawNumber(number: Int): Board {
            val newHits = numbers.entries
                .filter { it.value == number }
                .map { it.key }
            return copy(hits = hits + newHits)
        }

        private fun winPositions(): Set<Pos> {
            val colHitPositions = hits
                .groupBy { it.x }
                .values
                .filter { it.size == 5 }
                .flatten()
                .toSet()

            val rowHitPositions = hits
                .groupBy { it.y }
                .values
                .filter { it.size == 5 }
                .flatten()
                .toSet()

            return colHitPositions + rowHitPositions
        }

        fun hasWon() = winPositions().isNotEmpty()

        fun score(lastDrawn: Int): Int {
            val unmarked = numbers.entries
                .filterNot { hits.contains(it.key) }
                .map { it.value }
            return unmarked.sum() * lastDrawn
        }
    }

    data class WorldState(
        val boards: List<Board>,
        val undrawn: List<Int>,
        val drawn: List<Int>,
        val winningScores: List<Int> = listOf()
    )

    fun calculateWinScore(input: String): Int {
        val boardSim = constructSimulationSequence(input)
        val winningState = boardSim
            .dropWhile { state -> state.winningScores.isEmpty() }
            .first()
        return winningState.winningScores.first()
    }

    fun calculateWinScoreLast(input: String): Int {
        val boardSim = constructSimulationSequence(input)
        return boardSim.last().winningScores.last()
    }


    private fun constructSimulationSequence(input: String): Sequence<WorldState> {
        val lines = input.trim().lines()
        val numbersToDraw = lines[0].split(",").map { it.toInt() }
        val boards = lines
            .drop(2)
            .chunked(6)
            .map { parseBoard(it.take(5)) }
        val initState = WorldState(boards, numbersToDraw, listOf())
        val boardSim = generateSequence(initState) { state ->
            if (state.undrawn.isEmpty()) {
                return@generateSequence null
            }
            val drawNumber = state.undrawn.first()
            val newBoards = state.boards.map { it.drawNumber(drawNumber) }
            val newDrawn = state.drawn + drawNumber
            val newUndrawn = state.undrawn.drop(1)
            val newWinningScores = state.winningScores + newBoards
                .filter { it.hasWon() }
                .map { it.score(drawNumber) }
            val newBoardsLeft = newBoards.filterNot { it.hasWon() }
            WorldState(newBoardsLeft, newUndrawn, newDrawn, newWinningScores)
        }
        return boardSim
    }

    private fun parseBoard(lines: List<String>): Board {
        require(lines.size == 5)
        val numbers = lines
            .flatMapIndexed { lineIndex, line ->
                val lineNumbers = line.trim().split(Regex("""\s+"""))
                lineNumbers.mapIndexed { colIndex, numberStr -> Pos(colIndex, lineIndex) to numberStr.toInt() }
            }
            .toMap()
        return Board(numbers)
    }

}
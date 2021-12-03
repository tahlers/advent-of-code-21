package aoc21

object Day2 {

    enum class Direction {
        UP, DOWN, FORWARD;

        companion object {
            fun parse(input: String) =
                when (input.uppercase()) {
                    "UP" -> UP
                    "DOWN" -> DOWN
                    "FORWARD" -> FORWARD
                    else -> throw IllegalStateException()
                }
        }
    }

    data class Step(val direction: Direction, val distance: Int)

    data class Pos(val x: Int = 0, val depth: Int = 0) {
        fun move(step: Step): Pos =
            when (step.direction) {
                Direction.UP -> Pos( this.x, this.depth - step.distance)
                Direction.DOWN -> Pos( this.x, this.depth + step.distance )
                Direction.FORWARD -> Pos( this.x + step.distance, this.depth)
            }
    }

    data class PosWithAim(val x: Int =0, val depth: Int = 0, val aim: Int = 0){
        fun move(step: Step): PosWithAim = when (step.direction) {
                Direction.UP -> PosWithAim( x, depth, aim - step.distance)
                Direction.DOWN -> PosWithAim(x, depth, aim + step.distance)
                Direction.FORWARD -> PosWithAim(x + step.distance, depth + aim * step.distance, aim)
            }
    }

    fun calculatePos(input: String): Int {
        val steps = parseInput(input)
        val finalPos: Pos = steps.fold(Pos(), Pos::move)
        return finalPos.x * finalPos.depth
    }

    fun calculatePosWithAim(input: String): Int {
        val steps = parseInput(input)
        val finalPos: PosWithAim = steps.fold(PosWithAim(), PosWithAim::move)
        return finalPos.x * finalPos.depth
    }

    private fun parseInput(input: String): List<Step> {
        return input.trim()
            .lines()
            .map {
                val (dirPart, distancePart) = it.split(" ")
                Step(Direction.parse(dirPart), distancePart.toInt())
            }
    }

}
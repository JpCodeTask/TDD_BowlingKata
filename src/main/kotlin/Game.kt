class Game {
    var score: Int = 0
        private set
        get() = rolls.sum()

    private val rolls = IntArray(20)
    private var numberOfRolls = 0

    fun roll(pins: Int){
        if (isSpare())
            rolls[numberOfRolls -1] += pins

        rolls[numberOfRolls] = pins
        numberOfRolls++
    }

    private fun isSpare(): Boolean =
        numberOfRolls > 1 && rolls[numberOfRolls - 2] + rolls[numberOfRolls -1] == 10
}

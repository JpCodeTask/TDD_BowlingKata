import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameTest {

    companion object{
        lateinit var game: Game
    }

    @BeforeEach
    fun setUp() {
        game = Game()
    }

    @Test
    fun `when new game then score is 0`() {
        assertEquals(0, game.score)
    }

    @Test
    fun `when roll more then 0 then score change`() {
        game.roll(3)
        assertEquals(3, game.score)
    }

    @Test
    fun `when roll twenty 1 then score is 20`(){
        rollMany(20 ,1)
        assertEquals(20, game.score)
    }

    private fun rollMany(numberOfRolls: Int, pinsInSingleRoll: Int){
        for(roll in 1..numberOfRolls)
            game.roll(pinsInSingleRoll)
    }

    @Test
    fun `when roll single spare and zeros`(){
        game.roll(6)
        game.roll(4)
        game.roll(3)
        rollMany(17, 0)
        assertEquals(16, game.score)
    }

}
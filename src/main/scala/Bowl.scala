import dice.DieFace
import scala.util.Random

class Bowl {
  private var diceLeft = 6

  def generateDieFaces(): List[DieFace] = {
    if diceLeft <= 0 then return List()

    val generated = for i <- (1 to diceLeft).toList yield DieFace.fromInt(Random.between(1, 7))
    generated
  }

  def decreaseDiceLeft(amount: Int): Unit = {
    diceLeft -= amount
  }
}

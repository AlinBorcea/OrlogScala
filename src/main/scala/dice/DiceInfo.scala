package dice

import dice.DieFace.*

case class DiceInfo(countAxes: Int,
                    countArrows: Int,
                    countHelmets: Int,
                    countShields: Int,
                    countHands: Int)

object DiceInfo {
  def fromList(dice: List[DieFace]): DiceInfo = {
    val axes = dice.count(p => p == Ax)
    val arrows = dice.count(p => p == Arrow)
    val helmets = dice.count(p => p == Helmet)
    val shields = dice.count(p => p == Shield)
    val hands = dice.count(p => p == Hand)
    
    DiceInfo(axes, arrows, helmets, shields, hands)
  }
}

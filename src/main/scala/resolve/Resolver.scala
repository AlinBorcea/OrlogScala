package resolve

import dice.{DiceInfo, DieFace}

class Resolver {
  def resolve(dice1: List[DieFace], dice2: List[DieFace]): ResolveRoundInfo = {
    val info1 = DiceInfo.fromList(dice1)
    val info2 = DiceInfo.fromList(dice2)

    val health1 = 0 - (if info2.countAxes > info1.countHelmets then info2.countAxes - info1.countHelmets else 0)
      - (if info2.countArrows > info1.countShields then info2.countArrows - info1.countShields else 0)

    val health2 = 0 - (if info1.countAxes > info2.countHelmets then info1.countAxes - info2.countHelmets else 0)
      - (if info1.countArrows > info2.countShields then info1.countArrows - info2.countShields else 0)

    ResolveRoundInfo(health1, health2)
  }
}

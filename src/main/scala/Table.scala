import dice.DieFace
import dice.DieFace.*

class Table(val reorderStrategy: List[DieFace] => List[DieFace],
            var dice: List[DieFace] = List()) {

  def reorder(): Unit = {
    dice = reorderStrategy(dice)
  }
}

object Table {
  def create(reorderStrategy: List[DieFace] => List[DieFace]): Table = {
    Table(reorderStrategy)
  }
  
  def sortDefenseFirst(dice: List[DieFace]): List[DieFace] = {
    val axes = dice.filter(_ == Ax)
    val arrows = dice.filter(_ == Arrow)
    val helmets = dice.filter(_ == Helmet)
    val shields = dice.filter(_ == Shield)
    val hands = dice.filter(_ == Hand)

    helmets ::: shields ::: axes ::: arrows ::: hands
  }
  
  def sortAttackFirst(dice: List[DieFace]): List[DieFace] = {
    val axes = dice.filter(_ == Ax)
    val arrows = dice.filter(_ == Arrow)
    val helmets = dice.filter(_ == Helmet)
    val shields = dice.filter(_ == Shield)
    val hands = dice.filter(_ == Hand)

    axes ::: arrows ::: helmets ::: shields ::: hands
  }
  
}

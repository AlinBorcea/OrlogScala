import dice.DieFace

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
}

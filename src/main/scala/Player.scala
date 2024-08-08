class Player(val table: Table) {
  private var health = 15
  val bowl = Bowl()

  def decreaseHealth(amount: Int): Unit = {
    health -= amount
  }

  def isHealthEmpty: Boolean = health <= 0
}
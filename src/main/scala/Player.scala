class Player:
  private var health = 15

  def decreaseHealth(amount: Int): Unit = {
    health -= amount
  }
  
  def isHealthEmpty: Boolean = health <= 0

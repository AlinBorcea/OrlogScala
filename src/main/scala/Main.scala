import dice.DieFace
import resolve.Resolver

@main def main(): Unit = {
  val player1 = Player(Table.create(Table.sortDefenseFirst))
  val player2 = Player(Table.create(Table.sortAttackFirst))

  for i <- 1 to 2 do
    initPlayer(player1)
    initPlayer(player2)

    player1Turn(player1)
    player2Turn(player2)

    if i % 2 == 1 then
      finishRound(player1, player2)
}

private def initPlayer(player: Player): Unit = {
  val dice = player.bowl.generateDieFaces()
  player.table.dice = player.table.dice ::: dice
}

def player1Turn(player: Player): Unit = {
  player.bowl.decreaseDiceLeft(6)
}

def player2Turn(player: Player): Unit = {
  System.out.println(player.table.dice)
  //System.out.println("Keep first n = ?");
  //int n = scanner.nextInt();
  player.bowl.decreaseDiceLeft(6)
}

private def finishRound(player1: Player, player2: Player): Unit = {
  val resolver = new Resolver
  val roundInfo = resolver.resolve(player1.table.dice, player2.table.dice)

  player1.decreaseHealth(roundInfo.playerOneChangeInHealth)
  player2.decreaseHealth(roundInfo.playerTwoChangeInHealth)
  player1.table.reorder()
  player2.table.reorder()

  System.out.println(player1.table.dice)
  System.out.println(player2.table.dice)
  System.out.println("P1 = " + roundInfo.playerOneChangeInHealth + "\nP2 = " + roundInfo.playerTwoChangeInHealth)

  player1.table.dice = List()
  player2.table.dice = List()
}
package dice

enum DieFace {
  case None, Ax, Arrow, Helmet, Shield, Hand
}

object DieFace {
  def fromInt(x: Int): DieFace = x match
    case 1 => Ax
    case 2 => Arrow
    case 3 => Helmet
    case 4 => Shield
    case 5 => Hand
    case _ => None
}
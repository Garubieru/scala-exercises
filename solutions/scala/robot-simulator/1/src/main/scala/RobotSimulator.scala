enum Bearing:
  case North, East, South, West

val DirectionMap = Map(
    (Bearing.North, 'R') -> Bearing.East,
    (Bearing.North, 'L') -> Bearing.West,
    (Bearing.South, 'R') -> Bearing.West,
    (Bearing.South, 'L') -> Bearing.East,
    (Bearing.East, 'R') -> Bearing.South,
    (Bearing.East, 'L') -> Bearing.North,
    (Bearing.West, 'R') -> Bearing.North,
    (Bearing.West, 'L') -> Bearing.South,
  )


val BearingStep = Map(
  Bearing.North -> (0, 1),
  Bearing.South -> (0, -1),
  Bearing.East -> (1, 0),
  Bearing.West -> (-1, 0),
)

case class Robot(var bearing: Bearing, var coordinates: (Int, Int)):
  private var step: (Int, Int) = BearingStep(bearing)

  def simulate(instructions: String): Robot = {
    instructions.foreach{ instruction =>
      instruction match {
        case 'A' => advance
        case 'R' => turnRight
        case 'L' => turnLeft
        case _ => println("No such command")   
      }
   }
    this
  }

  def advance: Robot = {
    coordinates = (coordinates._1 + step._1, coordinates._2 + step._2)
    this
  }

  def turnRight: Robot = turn('R')

  def turnLeft: Robot = turn('L')

  def turn(side: Char): Robot = {
    val nextBearing = DirectionMap((bearing, side))
    bearing = nextBearing
    step = BearingStep(nextBearing)        
    this
  }

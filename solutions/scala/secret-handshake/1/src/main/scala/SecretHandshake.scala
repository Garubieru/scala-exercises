object SecretHandshake:
  private val actions = List[String](
    "wink",
    "double blink",
    "close your eyes",
    "jump",
    "reverse",
  )

  def commands(num: Int): List[String] = {
    if num == 0 then return List()
    var binaryNums = List[Int]()
    var quotient: Int = num

    while 
      quotient > 1
    do
      val rest: Int = quotient % 2
      quotient = quotient >> 1
      binaryNums = rest +: binaryNums
    
    binaryNums = quotient +: binaryNums
    var parsedActions = binaryNums.reverse.zipWithIndex.map{
      case (value, idx) => (value -> actions(idx))
    }.filter{
      case (value, action) => value == 1
    }.map{
      case (value, action) => action
    }
    if parsedActions.last == "reverse" then parsedActions.dropRight(1).reverse else parsedActions
}
object ArmstrongNumbers {
  def isArmstrongNumber(num: Int): Boolean = {
    var digits = List[Int]()
    var currNum = num
    while (currNum >= 10) {
      val remainder = currNum % 10
      currNum = currNum / 10
      digits = remainder +: digits
    }
    digits = currNum +: digits

    val sum = digits.zipWithIndex.foldLeft(0)({
      case (acc, (digit, i)) => { 
          acc + math.pow(digit, digits.size).toInt
      }
    })
    sum == num
  }
}
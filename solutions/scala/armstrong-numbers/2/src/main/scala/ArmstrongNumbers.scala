object ArmstrongNumbers {
  def isArmstrongNumber(num: Int): Boolean = {
    if (num < 10) {
      return true
    }
    val remainders = Iterator.
      iterate(num)(_ / 10).
      takeWhile(_ > 0).
      map(n => n % 10).
      toList
    remainders.map(math.pow(_, remainders.size).toInt).sum == num
  }
}
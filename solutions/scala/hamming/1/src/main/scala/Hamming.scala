object Hamming {
  def distance(dnaStrandOne: String, dnaStrandTwo: String): Option[Int] = {
    if dnaStrandOne.length != dnaStrandTwo.length then {
      return None
    }

    var diff: Int = 0
    for (i <- dnaStrandOne.indices) {
      if dnaStrandOne.lift(i) != dnaStrandTwo.lift(i) then {
        diff += 1
      }
    }
    return Some(diff)
  }
}

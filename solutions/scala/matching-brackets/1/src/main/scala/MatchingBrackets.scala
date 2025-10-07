object MatchingBrackets {
  val pairs: Map[Char, Char] = Map(
    ']' -> '[',
    '}' -> '{',
    ')' -> '('
  )

  def isPaired(brackets: String): Boolean = {
    brackets
      .foldLeft[Seq[Char]](
        Seq[Char]()
      )((acc, el) => {
        el match {
          case '[' | '{' | '(' => acc :+ el
          case ']' | '}' | ')' =>
            if !acc.isEmpty && acc.last == pairs(el) then acc.dropRight(1)
            else acc :+ el
          case _ => acc
        }
      })
      .isEmpty
  }
}
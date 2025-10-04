object Bob {
  def response(statement: String): String = {
    // val cleanedStatement = statement.trim()
    // isUppercaseStmt = isAllUppercase(cleanedStatement)
    // endsWithQuestion = cleanedStatement.endsWith("?")
    // if isUppercaseStmt && endsWithQuestion then {
      // "Calm down, I know what I'm doing!"
    // } else if endsWithQuestion then {
      // "Sure."
    // } else if isUppercaseStmt then {
      // "Whoa, chill out!"
    // } else if cleanedStatement.isEmpty then {
      // "Fine. Be that way!"
    // } else {
      // "Whatever."
    // }

    val cleanedStatement = statement.trim()
    val isUppercaseStmt = isAllUppercase(cleanedStatement)
    val endsWithQuestion = cleanedStatement.endsWith("?")

  (cleanedStatement.isEmpty, isUppercaseStmt, endsWithQuestion) match
    case (true, _, _)      => "Fine. Be that way!"
    case (_, true, true)   => "Calm down, I know what I'm doing!"
    case (_, false, true)  => "Sure."
    case (_, true, false)  => "Whoa, chill out!"
    case _                 => "Whatever."
    }

  def isAllUppercase(statement: String): Boolean = {
    val letters = statement.filter(_.isLetter)
    if letters.isEmpty then false
    else letters.forall(_.isUpper)
  }
}

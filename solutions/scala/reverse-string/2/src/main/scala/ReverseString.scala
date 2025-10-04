object ReverseString {
  def reverse(str: String): String = {
    (for (i <- str.length-1 to 0 by -1) yield str(i)).mkString
  }
}

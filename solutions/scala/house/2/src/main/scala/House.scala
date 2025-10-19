object House {
  val elements = List(
    ("house", "Jack built."),
    ("malt", "lay in"),
    ("rat", "ate"),
    ("cat", "killed"),
    ("dog", "worried"),
    ("cow with the crumpled horn", "tossed"),
    ("maiden all forlorn", "milked"),
    ("man all tattered and torn", "kissed"),
    ("priest all shaven and shorn", "married"),
    ("rooster that crowed in the morn", "woke"),
    ("farmer sowing his corn", "kept"),
    ("horse and the hound and the horn", "belonged to")
  )

  def recite(start: Int, end: Int): String = {
    (start to end).map(reciteOne).mkString("\n") + "\n\n"
  }

  def reciteOne(index: Int): String = {
    "This is the " + elements
      .slice(0, index)
      .reverse
      .map { (noun, verb) => s"$noun that $verb" }
      .reduce(_ + " the " + _)
      .mkString
  }
}
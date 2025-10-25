object FoodChain {
  val order = Seq("fly", "spider", "bird", "cat", "dog", "goat", "cow", "horse")

  val verseMap = Map[String, (String, String)](
    "fly" -> (".\n", "I don't know why she swallowed the fly. Perhaps she'll die.\n"),
    "spider" -> (" that wriggled and jiggled and tickled inside her.\n", "It wriggled and jiggled and tickled inside her.\n"),
    "bird" -> (".\n", "How absurd to swallow a bird!\n"),
    "cat" -> (".\n", "Imagine that, to swallow a cat!\n"),
    "dog" -> (".\n", "What a hog, to swallow a dog!\n"),
    "goat" -> (".\n", "Just opened her throat and swallowed a goat!\n"),
    "cow" -> (".\n", "I don't know how she swallowed a cow!\n"),
    "horse" -> (".\n", "She's dead, of course!\n")
  )

  def recite(start: Int, end: Int): String = {
    return (start to end).map(reciteOne).mkString("\n") + "\n"
  }

  def reciteOne(i: Int): String = {
    val slicedVerses = order.slice(0, i).reverse

    val curr = slicedVerses.head
    val verse = verseMap.getOrElse(curr, ("", "\n"))._2

    val output = s"I know an old lady who swallowed a $curr.\n" + verse
    if slicedVerses.size == 1 || i == order.size then {
      output
    } else {
      output + slicedVerses.sliding(2).map({
      case Seq(curr, next) => {
        s"She swallowed the $curr to catch the $next${verseMap.getOrElse(next, ("", ""))._1}"
      }
    }).mkString + verseMap.getOrElse("fly", ("", ""))._2
    }
  }
}
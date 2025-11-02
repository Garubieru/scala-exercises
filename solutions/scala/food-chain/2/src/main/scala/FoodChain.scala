object FoodChain {
  val creatures = Seq[String](
    "fly",
    "spider",
    "bird",
    "cat",
    "dog",
    "goat",
    "cow",
    "horse"
  )

  val creatureSentence = Map[String, (String, Option[String])](
    "fly" -> (
      "I don't know why she swallowed the fly. Perhaps she'll die.",
      None
    ),
    "spider" -> (
      "It wriggled and jiggled and tickled inside her.",
      Some(" that wriggled and jiggled and tickled inside her.")
    ),
    "bird" -> ("How absurd to swallow a bird!", None),
    "cat" -> ("Imagine that, to swallow a cat!", None),
    "dog" -> ("What a hog, to swallow a dog!", None),
    "goat" -> ("Just opened her throat and swallowed a goat!", None),
    "cow" -> ("I don't know how she swallowed a cow!", None),
    "horse" -> ("She's dead, of course!", None)
  )

  def recite(start: Int, end: Int): String = {
    (start to end).map(reciteOne).mkString("\n") + "\n"
  }

  def reciteOne(idx: Int): String = {
    val creaturesToRecite = creatures.slice(0, idx).reverse
    val isSingleRecite = idx == 1 || idx == creatures.size

    "I know an old lady who swallowed a " + creaturesToRecite(
      0
    ) + ".\n" + creatureSentence(
      creaturesToRecite(0)
    )._1 + "\n" + (if !isSingleRecite then
                     creaturesToRecite.zipWithIndex.foldLeft("") {
                       case (acc, data) => {
                         acc + (
                           if data(1) + 1 < creaturesToRecite.size then
                             val nextCreature = creaturesToRecite(data(1) + 1)
                             val extra =
                               creatureSentence(nextCreature)._2.getOrElse(
                                 "."
                               ) + "\n"
                             s"She swallowed the ${data(0)} to catch the $nextCreature$extra"
                           else s"${creatureSentence(data(0))._1}\n"
                         )
                       }
                     }
                   else "")

  }
}
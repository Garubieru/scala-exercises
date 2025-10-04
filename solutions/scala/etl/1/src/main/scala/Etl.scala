import scala.collection.mutable

object Etl {
  def transform(scoreMap: Map[Int, Seq[String]]): Map[String, Int] = {
    // var newScoreMap = Map[String, Int]()
    // scoreMap.foreach { case (score, letters) =>
      // letters.foreach { letter =>
        // val lowerLetter = letter.toLowerCase
        // newScoreMap = newScoreMap + (lowerLetter -> score)
      // }
    // }
    // newScoreMap

    scoreMap.flatMap{ case (score, letters) => {
      letters.map(letter => letter.toLowerCase -> score)
    }}
  }
}

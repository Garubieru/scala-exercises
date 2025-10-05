import scala.util.Random
import scala.collection.mutable

val LETTERS = for (i <- 0 until 26) yield (65+i).toChar
val NUMS = for (i <- 0 until 10) yield i

val LettersCache = mutable.Map[String, Boolean]()
val NumsCache = mutable.Map[String, Boolean]()

class Robot:
  var name: String = ""
  val r = new Random()

  name = generateName

  def generateName: String = {
    val letters = generateLetters(2)
    val nums = generateNums(3)
    letters + nums
  }

  def reset() = {
    name = generateName
  }

  def generateLetters(size: Int): String = {
    while (true) {
      val letter = (for (_ <- 0 until size) yield LETTERS(r.between(0, 26))).mkString
      LettersCache.get(letter) match {
        case None => {
          LettersCache.put(letter, true)
          return letter
        }
        case Some(_) => ()
      }
    }
    return ""
  }

  def generateNums(size: Int): String = {
    while (true) {
      val num = (for (_ <- 0 until size) yield NUMS(r.between(0, 10))).mkString
      NumsCache.get(num) match {
        case None => {
          NumsCache.put(num, true)
          return num
        }
        case Some(_) => ()
      }
    }
    return "" 
  }



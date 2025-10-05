import scala.util.Random
import scala.collection.mutable

var ID_GENERATOR = RobotIdGenerator(2, 3)

class Robot:
  var name: String = ""

  name = generateName

  def generateName: String = ID_GENERATOR.generateId

  def reset() = {
    name = generateName
  }
 

class RobotIdGenerator(alphaSize: Int, numSize: Int):
  val r = new Random()
  val ElementsCache = mutable.Map[String, Boolean]()

  val LETTERS = 'A' to 'Z'
  val NUMS = '0' to '9'

  def generateId: String = {
    while (true) {
      val letters = generateElements(alphaSize, LETTERS)
      val nums = generateElements(numSize, NUMS)  
      var id = (letters ++ nums).mkString
      ElementsCache.get(id) match {
        case None => {
          ElementsCache.put(id, true)
          return id
        }
        case Some(_) => ()
      }
    }
    return ""
  }

  def generateElements(size: Int, elements: Seq[Char]): Seq[Char] = {
      (for (_ <- 0 until size) yield elements(r.nextInt(elements.length)))  
  }



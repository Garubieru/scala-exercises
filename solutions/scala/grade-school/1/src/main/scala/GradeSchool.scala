import scala.collection.mutable

class School {
  type DB = mutable.Map[Int, Seq[String]]
  
  private val _db: DB = mutable.Map[Int, Seq[String]]().withDefaultValue(Seq.empty)

  def add(name: String, g: Int) = {
    _db.update(g, _db.getOrElse(g, Seq.empty) :+ name)
  }

  def db: DB = {
    _db
  }

  def grade(g: Int): Seq[String] = {
    db(g)
  }

  def sorted: DB = {
    val sorted = mutable.SortedMap[Int, Seq[String]]()
    val keys = _db.keys.toSeq.sorted
    for k <- keys do sorted(k) = db(k).sorted
    sorted
  }
}


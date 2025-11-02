object CollatzConjecture {
  def steps(n: Int): Option[Int] = {
    if n <= 0 then None
    else Some(Iterator
      .iterate(n) { n => if n % 2 == 0 then n / 2 else 3 * n + 1 }
      .takeWhile((n) => n != 1)
      .size)
  }
}
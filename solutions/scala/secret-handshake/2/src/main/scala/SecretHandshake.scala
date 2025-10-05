object SecretHandshake:
  def commands(num: Int): Seq[String] = {
    val SIGNS = List[String](
      "wink",
      "double blink",
      "close your eyes",
      "jump",
    )

    val signs = (0 until SIGNS.length).foldLeft(Seq(): Seq[String])((seq, idx) => {
      if (1 << idx & num) != 0 then seq :+ SIGNS(idx)
      else seq
    })

    if (num & 16) != 0 then signs.reverse else signs
  }
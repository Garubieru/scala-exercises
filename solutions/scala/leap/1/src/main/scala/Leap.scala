object Leap {
  def leapYear(year: Int): Boolean = {
    leapYearBy4(year) || leapYearBy400(year)
  }

  def leapYearBy4(year: Int): Boolean = {
    year % 4 == 0 && year % 100 != 0
  }

  def leapYearBy400(year: Int) = {
    year % 400 == 0
  }
}

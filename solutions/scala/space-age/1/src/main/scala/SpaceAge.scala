object SpaceAge {
  def onMercury(age: Double): Double = {
      calculateAge(age, 0.2408467)
  }

  def onVenus(age: Double): Double = {
      calculateAge(age, 0.61519726)
  }

  def onEarth(age: Double): Double = {
      calculateAge(age, 1.0)
  }

  def onMars(age: Double): Double = {
      calculateAge(age, 1.8808158)
  }

  def onJupiter(age: Double): Double = {
      calculateAge(age, 11.862615)
  }

  def onSaturn(age: Double): Double = {
      calculateAge(age, 29.447498)
  }

  def onUranus(age: Double): Double = {
      calculateAge(age, 84.016846)
  }

  def onNeptune(age: Double): Double = {
      calculateAge(age, 164.79132)
  }

  def calculateAge(ageInSeconds: Double, factor: Double): Double = {
    var secondsInAYear = 365.25 * 24 * 3600 * factor
    ageInSeconds / secondsInAYear
  }
}

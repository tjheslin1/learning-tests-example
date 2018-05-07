package domain

sealed trait Dog{
  def name
}

case class Greyhound(petName: String, runningSpeed: Int) extends Dog {
  val name = petName.toLowerCase
}

case class Westie(petName: String, goodBoy: Boolean) extends Dog {
  val name = petName.toLowerCase
}

case class Patterdale(petName: String, trained: Boolean) extends Dog {
  val name = petName.toLowerCase
}

import domain.{Greyhound, Patterdale, Westie}
import org.scalatest.{Matchers, WordSpec}

class Json4sLearningSpec extends WordSpec with Matchers {

  import org.json4s._
  import org.json4s.native.JsonMethods._

  implicit val formats = DefaultFormats

  "Json4s" should {
    "convert JSON into domain model" in {
      val greyhoundJson = """{ "petName": "santasLittleHelper", "runningSpeed": 42 }"""
      val westieJson = """{ "petName": "joey", "goodBoy": true }"""
      val patterdaleJson = """{ "petName": "woody", "trained": true }"""

      parse(greyhoundJson).extract[Greyhound] shouldBe Greyhound("santasLittleHelper", 42)
      parse(westieJson).extract[Westie] shouldBe Westie("joey", true)
      parse(patterdaleJson).extract[Patterdale] shouldBe Patterdale("woody", true)
    }
  }
}

import domain.{Greyhound, Patterdale, Westie}
import org.scalatest.{Matchers, WordSpec}

class Json4sLearningSpec extends WordSpec with Matchers {

  import org.json4s._
  import org.json4s.native.JsonMethods._
  import org.json4s.native.Serialization._

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

    "produce JSON from domain model" in {
      val greyhound = Greyhound("santasLittleHelper", 42)
      val westie = Westie("joey", true)
      val patterdale = Patterdale("woody", true)

      write[Greyhound](greyhound) shouldBe """{"petName":"santasLittleHelper","runningSpeed":42}"""
      write[Westie](westie) shouldBe """{"petName":"joey","goodBoy":true}"""
      write[Patterdale](patterdale) shouldBe """{"petName":"woody","trained":true}"""
    }
  }
}

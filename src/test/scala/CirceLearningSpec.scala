import domain.{Greyhound, Patterdale, Westie}
import org.scalatest.{EitherValues, Matchers, WordSpec}

class CirceLearningSpec extends WordSpec with Matchers with EitherValues {

  import io.circe._
  import io.circe.generic.auto._
  import io.circe.parser._
  import io.circe.syntax._

  "Circe" should {
    "convert JSON into domain model" in {
      val greyhoundJson   = """{"petName":"santasLittleHelper","runningSpeed":42}"""
      val westieJson      = """{"petName":"joey","goodBoy":true}"""
      val patterdaleJson  = """{"petName":"woody","trained":true}"""

      parse(greyhoundJson).getOrElse(Json.Null).as[Greyhound].right.value   shouldBe Greyhound("santasLittleHelper", 42)
      parse(westieJson).getOrElse(Json.Null).as[Westie].right.value         shouldBe Westie("joey", true)
      parse(patterdaleJson).getOrElse(Json.Null).as[Patterdale].right.value shouldBe Patterdale("woody", true)
    }

    "produce JSON from domain model" in {
      val greyhound   = Greyhound("santasLittleHelper", 42)
      val westie      = Westie("joey", true)
      val patterdale  = Patterdale("woody", true)

      greyhound.asJson.noSpaces  shouldBe """{"petName":"santasLittleHelper","runningSpeed":42}"""
      westie.asJson.noSpaces     shouldBe """{"petName":"joey","goodBoy":true}"""
      patterdale.asJson.noSpaces shouldBe """{"petName":"woody","trained":true}"""
    }
  }
}
package com.github.aztek.porterstemmer

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

/**
 * ScalaTest specification for PorterStemmer.
 *
 * @author Evgeny Kotelnikov <evgeny.kotelnikov@gmail.com>
 */
@RunWith(classOf[JUnitRunner])
class PorterStemmerTest extends FlatSpec with ShouldMatchers {
  behavior of "Porter's stemmer"

  it should "stem plurals" in {
    val plurals = Map(
      "caresses" -> "caress",
      "ponies" -> "poni",
      "ties" -> "ti",
      "caress" -> "caress",
      "cats" -> "cat"
    )

    for ((word, stem) <- plurals)
      expect(stem)(PorterStemmer.stem(word))
  }

  it should "stem past participles" in {
    val participles = Map(
      "feed" -> "fe",
      "agreed" -> "agr",
      "plastered" -> "plaster",
      "bled" -> "bled",
      "motoring" -> "motor",
      "sing" -> "sing",

      "conflated" -> "conflat",
      "troubled" -> "troubl",
      "sized" -> "size",
      "hopping" -> "hop",
      "tanned" -> "tan",
      "falling" -> "fall",
      "hissing" -> "hiss",
      "fizzed" -> "fizz",
      "failing" -> "fail",
      "filing" -> "file",

      "happy" -> "happi",
      "sky" -> "sky"
    )

    for ((word, stem) <- participles)
      expect(stem)(PorterStemmer.stem(word))
  }

  it should "change suffixes" in {
    val changes = Map(
      "relational" -> "relat",
      "conditional" -> "condit",
      "rational" -> "ration",
      "valenci" -> "valenc",
      "hesitanci" -> "hesit",
      "digitizer" -> "digit",
      "conformabli" -> "conform",
      "radicalli" -> "radic",
      "differentli" -> "differ",
      "vileli" -> "vile",
      "analogousli" -> "analog",
      "vietnamization" -> "vietnam",
      "predication" -> "predic",
      "operator" -> "oper",
      "feudalism" -> "feudal",
      "decisiveness" -> "decis",
      "hopefulness" -> "hope",
      "callousness" -> "callous",
      "formaliti" -> "formal",
      "sensitiviti" -> "sensit",
      "sensibiliti" -> "sensibl",

      "triplicate" -> "triplic",
      "formative" -> "form",
      "formalize" -> "formal",
      "electriciti" -> "electr",
      "electrical" -> "electr",
      "hopeful" -> "hope",
      "goodness" -> "good",

      "revival" -> "reviv",
      "allowance" -> "allow",
      "inference" -> "infer",
      "airliner" -> "airlin",
      "gyroscopic" -> "gyroscop",
      "adjustable" -> "adjust",
      "defensible" -> "defens",
      "irritant" -> "irrit",
      "replacement" -> "replac",
      "adjustment" -> "adjust",
      "dependent" -> "depend",
      "adoption" -> "adopt",
      "homologou" -> "homolog",
      "communism" -> "commun",
      "activate" -> "activ",
      "angulariti" -> "angular",
      "homologous" -> "homolog",
      "effective" -> "effect",
      "bowdlerize" -> "bowdler",

      "probate" -> "probat",
      "rate" -> "rate",
      "cease" -> "ceas",
      "controll" -> "control",
      "roll" -> "roll"
    )

    for ((word, stem) <- changes)
      expect(stem)(PorterStemmer.stem(word))
  }
}
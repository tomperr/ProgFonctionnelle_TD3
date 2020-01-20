package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AnagrammeSuite extends FunSuite {
    import Main.isAnagramme

    test("isAnagramme:") {
        assert(isAnagramme("".toList, "".toList))
    }

    test("isAnagramme: marion romain") {
        assert(isAnagramme("marion".toList, "romain".toList))
    }

    test("isAnagramme: corps porcs") {
        assert(isAnagramme("corps".toList, "porcs".toList))
    }

    test("isAnagramme: baignade  badinage") {
        assert(isAnagramme("baignade".toList, "badinage".toList))
    }

    test("isAnagramme: baignades badinage") {
        assert(!isAnagramme("baignades".toList, "badinage".toList))
    }
   test("isAnagramme: addd aaad") {
        assert(!isAnagramme("addd".toList, "aaad".toList))
    }
}

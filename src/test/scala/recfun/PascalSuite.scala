package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
    import Main.coefBinomial
    test("coefBinomial: col=0,row=2") {
        assert(coefBinomial(0, 2) === 1)
    }

    test("coefBinomial: col=1,row=2") {
        assert(coefBinomial(1, 2) === 2)
    }

    test("coefBinomial: col=1,row=3") {
        assert(coefBinomial(1, 3) === 3)
    }

    test("coefBinomial: col=4,row=3") {
        assert(coefBinomial(3, 4) === 4)
    }

    test("coefBinomial: col=2,row=4") {
        assert(coefBinomial(2, 4) === 6)
    }

    test("coefBinomial: colum must be little than colum") {
        intercept[IllegalArgumentException] {
            coefBinomial(8, 5)
        }
    }

    test("coefBinomial: colum must be positif") {
        intercept[IllegalArgumentException] {
            coefBinomial(-1, 8)
        }
    }

    test("coefBinomial: row must be positif") {
        intercept[IllegalArgumentException] {
            coefBinomial(1, -8)
        }
    }
}

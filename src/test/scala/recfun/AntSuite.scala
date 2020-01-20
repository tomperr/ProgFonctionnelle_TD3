package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AntSuite extends FunSuite {
    import Main.ant
    test("ant: etape 1 - 5 iterations") {
        assert(ant(List(1), 5) === List(3, 1, 2, 2, 1, 1))
    }

    test("ant: etape 3 - 2 iterations") {
        assert(ant(List(1, 2, 1, 1), 2) === List(3, 1, 2, 2, 1, 1))
    }

    test("ant: etape 1 - 1 iterations") {
        assert(ant(List(1), 1) === List(1, 1))
    }

    test("ant: etape 1 - 10 iterations") {
        assert(ant(List(1), 10) === List(1, 1, 1, 3, 1, 2, 2, 1, 1, 3, 3, 1, 1, 2, 1, 3, 2, 1, 1, 3, 2, 1, 2, 2, 2, 1))
    }

    test("ant: null ") {
        intercept[IllegalArgumentException] {
            ant(List(), 10)
        }
    }
}

package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PgcdSuite extends FunSuite {
    import Main.pgcd

    test("pgcd: 8 10") {
        assert(pgcd(8, 10) === 2)
    }

    test("pgcd: 10 8") {
        assert(pgcd(10, 8) === 2)
    }

    test("pgcd: 7 4") {
        assert(pgcd(7, 4) === 1)
    }

    test("pgcd: 4 7") {
        assert(pgcd(4, 7) === 1)
    }

    test("pgcd: 1020 3060") {
        assert(pgcd(1020, 3060) === 1020)
    }

    test("pgcd: 952000 525") {
        assert(pgcd(952000, 525) === 175)
    }
}

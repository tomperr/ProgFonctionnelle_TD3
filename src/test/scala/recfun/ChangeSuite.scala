package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ChangeSuite extends FunSuite {
    import Main.nombreDeChange
    test("example basic") {
        assert(nombreDeChange(List(1, 2), 4) === 3)
    }

    test("liste 1") {
        assert(nombreDeChange(List(5, 10, 20, 50, 100, 200, 500), 300) === 1022)
    }

    test("pas de change") {
        assert(nombreDeChange(List(5, 10, 20, 50, 100, 200, 500), 301) === 0)
    }

    test("liste 2") {
        assert(nombreDeChange(List(5, 10, 20, 50, 100, 200, 500), 1790) === 1602321)
    }

    test("Montant egale a zero") {
        assert(nombreDeChange(List(5, 10, 20, 50, 100, 200, 500), 0) === 0)
    }

    test("Pas de monnaie egale a zero") {
        assert(nombreDeChange(List(), 10) === 0)
    }
}

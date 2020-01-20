package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {
  import Main.equili

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(equili("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(equili("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("balance: ':-)' is unbalanced") {
        assert(!equili(":-)".toList))
  }

  test("balance: counting is not enough") {
    assert(!equili("())(".toList))
  }

  test("balance: counting is not enough 2") {
    assert(!equili("()(".toList))
  }

  test("balance: counting is not enough 3") {
    assert(!equili(")(".toList))
  }
}

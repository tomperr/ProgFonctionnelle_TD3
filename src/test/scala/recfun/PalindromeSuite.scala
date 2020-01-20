package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PalindromeSuite extends FunSuite {
    import Main.isPalindrome

    test("isPalindrome with zero elem") {
        assert(isPalindrome(List()) === true)
    }

    test("isPalindrome with one elem") {
        assert(isPalindrome(List('1')) === true)
    }

    test("isPalindrome with many elem") {
        assert(isPalindrome(List('1', '2', '3', '4', '5', '4', '3', '2', '1')) === true)
    }

    test("isPalindrome: false") {
        assert(isPalindrome(List('1', '2', '3', '4', '5', '3', '2', '1')) === false)
    }
}

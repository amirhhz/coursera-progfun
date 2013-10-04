package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  test("singletonSet(1) contains 1") {
    new TestSets {
      assert(contains(s1, 1), "Singleton contains its element")
    }
  }

  test("singletonSet(2) does not contain 1") {
    new TestSets {
      assert(!contains(s2, 1), "Singleton does not contain element")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect contains elements in both sets") {
    new TestSets {
      val s12 = union(s1, s2)
      val s23 = union(s2, s3)
      val sx2 = intersect(s12, s23)
      assert(!contains(sx2, 1), "Intersect 1")
      assert(contains(sx2, 2), "Intersect 2")
      assert(!contains(sx2, 3), "Intersect 3")
    }
  }

  test("diff contains elements of 1st set not in 2nd set") {
    new TestSets {
      val s12 = union(s1, s2)
      val s23 = union(s2, s3)
      val d = diff(s12, s23)
      assert(contains(d, 1), "Diff 1")
      assert(!contains(d, 2), "Diff 2")
      assert(!contains(d, 3), "Diff 3")
    }
  }
  test("Filter returns set containg only members matching predicate") {
    new TestSets {
      val s123 = union(union(s1, s2), s3)
      val odd = filter(s123, x => if (x % 2 == 1) true else false)
      assert(contains(odd, 1), "Filter for odd 1")
      assert(!contains(odd, 2), "Filter for odd 2")
      assert(contains(odd, 3), "Filter for odd 3")
    }
  }

  test("Forall with test for positive integers") {
    new TestSets {
      val s123 = union(union(s1, s2), s3)
      assert(forall(s123, x => if (x > 0) true else false), "Forall positive ints")
    }
  }

  test("Forall with test for greater than 1 integers") {
    new TestSets {
      val s123 = union(union(s1, s2), s3)
      assert(!forall(s123, x => if (x > 1) true else false), "Forall >1 ints")
    }
  }

}

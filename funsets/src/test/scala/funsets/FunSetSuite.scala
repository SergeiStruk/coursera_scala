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
   * http://doc.scalatest.org/1.8/index.html#org.scalatest.FunSuite
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
    val s4 = singletonSet(1)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton 1")
      assert(contains(s2, 2), "Singleton 2")
      assert(contains(s3, 3), "Singleton 3")
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

  test("intersect contains all elements") {
    new TestSets {
      val s = intersect(s1, s2)
      val toTest = intersect(s1, s4)
      assert(!contains(s, 1), "Intersect 1")
      assert(!contains(s, 2), "Intersect 2")
      assert(contains(toTest, 1), "Intersect 3")
    }
  }

  test("diff contains all elements") {
    new TestSets {
      val s = diff(s1, s2)
      val toTest = diff(s1, s4)
      assert(contains(s, 1), "Diff 1")
      assert(!contains(toTest, 1), "Diff 3")
    }
  }

  test("filter contains all elements") {
    new TestSets {

      override val s1 = singletonSet(1)
      override val s2 = singletonSet(2)
      override val s3 = singletonSet(3)
      override val s4 = singletonSet(4)
      val s5 = singletonSet(5)

      val toTest1 = filter(s1, x => x < 5)
      val toTest2 = filter(s2, x => x < 5)
      val toTest3 = filter(s3, x => x < 5)
      val toTest4 = filter(s4, x => x < 5)
      val toTest5 = filter(s5, x => x < 5)

      assert(contains(toTest1, 1), "Filter 1")
      assert(contains(toTest2, 2), "Filter 2")
      assert(contains(toTest3, 3), "Filter 3")
      assert(contains(toTest4, 4), "Filter 4")
      assert(!contains(toTest5, 5), "Filter 5")
    }
  }

  test("forAll contains all elements") {
    new TestSets {
      val s = singletonSet(1)
      override val s1 = singletonSet(2)
      override val s2 = singletonSet(6)
      assert(forall(s, x => x < 3), "Forall 1")
      assert(forall(s1, x => x < 3), "Forall 2")
      assert(!forall(s2, x => x < 3), "Forall 3")
    }
  }

  test("exists contains all elements") {
    new TestSets {
    	override val s1 = singletonSet(1)
    	override val s2 = singletonSet(2)
    	override val s3 = singletonSet(3)
    	override val s4 = singletonSet(4)
    	assert(exists(s1, x => x < 5))
    	assert(!exists(s2, x => x > 5))
    	assert(exists(s3, x => x < 5))
    	assert(!exists(s4, x => x > 5))
    }
  }

  test("map contains all elements") {
    new TestSets {
    	val s = singletonSet(1000);
    	override val s2 = singletonSet(2);
    	val toTest = map(s, x => x - 1)
    	val toTest2 = map(s2, x => x + 12)
    	assert(contains(toTest, 999))
    	assert(contains(toTest2, 14))
    }
  }
}
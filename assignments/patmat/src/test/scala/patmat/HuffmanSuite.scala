package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }
  
  test("times - frequency of chars on empty string") {
    assert(times(string2Chars("")) === List())
  }  

  test("times - frequency of chars on single-char string") {
    assert(times(string2Chars("a")) === List(('a', 1)))
  }  

  test("times - frequency of chars on one repeated char") {
    assert(times(string2Chars("aa")) === List(('a', 2)))
  }  

  test("times - frequency of chars") {
    assert(times(string2Chars("ab")) === List(('b', 1), ('a', 1)))
    assert(times(string2Chars("abb")) === List(('b', 2), ('a', 1)))
    assert(times(string2Chars("caabbbc")) === List(('c', 2), ('b', 3), ('a', 2)))
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("singleton") {
    assert(singleton(List(Leaf('e',1), Leaf('t',2), Leaf('x',3))) === false)
    assert(singleton(List(Leaf('e',1))) === true)
  }

  test("combine of empty leaf list") {
    val leaflist = List()
    assert(combine(leaflist) === List())
  }

  test("combine of one-element leaf list") {
    val leaflist = List(Leaf('a', 1))
    assert(combine(leaflist) === List(Leaf('a', 1)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
}

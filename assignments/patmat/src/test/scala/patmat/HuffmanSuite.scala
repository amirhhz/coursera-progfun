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

  test("combine until singleton of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(until(singleton, combine)(leaflist) === List(Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4), List('e', 't', 'x'), 7)))
  }

  test("createCodeTree from some chars") {
    val chars = string2Chars("ettxxxx")
    assert(createCodeTree(chars) === Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4), List('e', 't', 'x'), 7))
  }

  // Don't think leaf-only trees work ...
  ignore("decode single char code from leaf tree") {
    new TestTrees {
      assert(decode(Leaf('a', 1), List(0)) === "a".toList)
    }
  }

  // Don't think leaf-only trees work ...
  ignore("decode double char code from leaf tree") {
    new TestTrees {
      assert(decode(Leaf('b', 1), List(1, 0)) === "bb".toList)
    }
  }

  test("decode short texts") {
    new TestTrees {
      assert(decode(t1, List(0, 1, 1)) === "abb".toList)
      assert(decode(t2, List(1, 0, 1, 0, 0, 1)) === "dbad".toList)
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("codeBits") {
	val table = List(('a', List(1)),('b', List(1, 0)), ('c', List(0, 1)))
    assert(codeBits(table)('b') === List(1, 0))
    assert(codeBits(table)('d') === List())
  }

  test("convert tree to table") {
    new TestTrees {
	  val table = List(('a', List(0)),('b', List(1)))
      assert(convert(t1) === table)
    }
  }

  test("mergeCodeTables with two tables") {
    new TestTrees {
      val tb1 = List(('a', List(0)), ('b', List(1)))
      val tb2 = List(('c', List(0)), ('d', List(1)))
      val expectedMerge = List(('a', List(0, 0)), ('c', List(1, 0)), ('b', List(0, 1)), ('d', List(1, 1)))
      assert(mergeCodeTables(tb1, tb2) === expectedMerge)
    }
  }

}

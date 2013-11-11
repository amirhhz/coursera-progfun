package week7

object pouringtest {
	val problem = new Pouring(Vector(4, 7))   //> problem  : week7.Pouring = week7.Pouring@61542a75
	problem.moves                             //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with we
                                                  //| ek7.pouringtest.problem.Move] = Vector(Empty(0), Empty(1), Fill(0), Fill(1), 
                                                  //| Pour(0,1), Pour(1,0))
  problem.solution(6)                             //> res1: Stream[week7.pouringtest.problem.Path] = Stream(Fill(1) Pour(1,0) Empt
                                                  //| y(0) Pour(1,0) Fill(1) Pour(1,0)-->Vector(4, 6), ?)
}
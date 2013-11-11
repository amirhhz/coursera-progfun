package week7

object pouringtest {
	val problem = new Pouring(Vector(4, 7))   //> problem  : week7.Pouring = week7.Pouring@5caf993e
	problem.moves                             //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with we
                                                  //| ek7.pouringtest.problem.Move] = Vector(Empty(0), Empty(1), Fill(0), Fill(1), 
                                                  //| Pour(0,1), Pour(1,0))
	problem.pathSets.take(3).toList           //> res1: List[Set[week7.pouringtest.problem.Path]] = List(Set(-->Vector(0, 0)),
                                                  //|  Set(Fill(1)-->Vector(0, 7), Pour(1,0)-->Vector(0, 0), Empty(0)-->Vector(0, 
                                                  //| 0), Fill(0)-->Vector(4, 0), Empty(1)-->Vector(0, 0), Pour(0,1)-->Vector(0, 0
                                                  //| )), Set(Fill(0) Pour(1,0)-->Vector(4, 0), Empty(1) Fill(0)-->Vector(4, 0), E
                                                  //| mpty(0) Empty(0)-->Vector(0, 0), Pour(0,1) Fill(0)-->Vector(4, 0), Fill(0) E
                                                  //| mpty(0)-->Vector(0, 0), Empty(0) Empty(1)-->Vector(0, 0), Pour(0,1) Pour(0,1
                                                  //| )-->Vector(0, 0), Empty(1) Pour(1,0)-->Vector(0, 0), Pour(0,1) Empty(0)-->Ve
                                                  //| ctor(0, 0), Fill(1) Pour(0,1)-->Vector(0, 7), Fill(0) Fill(1)-->Vector(4, 7)
                                                  //| , Fill(1) Fill(1)-->Vector(0, 7), Pour(1,0) Fill(0)-->Vector(4, 0), Pour(1,0
                                                  //| ) Pour(0,1)-->Vector(0, 0), Empty(0) Fill(1)-->Vector(0, 7), Fill(0) Pour(0,
                                                  //| 1)-->Vector(0, 4), Fill(1) Fill(0)-->Vector(4, 7), Fill(1) Pour(1,0)-->Vecto
                                                  //| r(4, 3), Pour(1,0) Fill(1)-->Vector(0, 7), Fill(0) Empty(1)-->Vector(4, 0), 
                                                  //| Empty(0) Pour(0,1)-->Vec
                                                  //| Output exceeds cutoff limit.
}
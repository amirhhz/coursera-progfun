package week7

object pouringtest {
	val problem = new Pouring(Vector(4, 7))   //> problem  : week7.Pouring = week7.Pouring@6719dc16
	problem.moves                             //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with we
                                                  //| ek7.pouringtest.problem.Move] = Vector(Empty(0), Empty(1), Fill(0), Fill(1), 
                                                  //| Pour(0,1), Pour(1,0))
}
package week6

object pairs {
 	def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0)
                                                  //> isPrime: (n: Int)Boolean
 
  val n = 7                                       //> n  : Int = 7
	val p = for {
		i <- 1 until n
		j <- 1 until i
		if isPrime(i + j)
	} yield (i, j)                            //> p  : scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2)
                                                  //| , (4,1), (4,3), (5,2), (6,1), (6,5))
  		
	
}
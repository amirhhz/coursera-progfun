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
  		
	def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
		(for ((x, y) <- xs zip ys) yield x * y).sum
                                                  //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double
	scalarProduct(Vector(2, 3, 1), Vector(1, 2, 1))
                                                  //> res0: Double = 9.0
}
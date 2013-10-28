package week6

object collections {
	val xs = Array(1, 2, 3, 44)               //> xs  : Array[Int] = Array(1, 2, 3, 44)
	xs map (x => x * x)                       //> res0: Array[Int] = Array(1, 4, 9, 1936)
	
	val st = "Hello World"                    //> st  : String = Hello World
	st filter (c => c.isUpper)                //> res1: String = HW
	st exists (c => c.isUpper)                //> res2: Boolean = true
	st forall (c => c.isUpper)                //> res3: Boolean = false

	val pairs = List(1, 2, 3) zip st          //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
	pairs.unzip                               //> res4: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))

	st flatMap (c => List('.', c))            //> res5: String = .H.e.l.l.o. .W.o.r.l.d
	
	xs.sum                                    //> res6: Int = 50
	xs.max                                    //> res7: Int = 44

	val r: Range = 1 until 5                  //> r  : Range = Range(1, 2, 3, 4)
	val s: Range = 1 to 5                     //> s  : Range = Range(1, 2, 3, 4, 5)
	1 to 10 by 3                              //> res8: scala.collection.immutable.Range = Range(1, 4, 7, 10)
	10 until 3 by -2                          //> res9: scala.collection.immutable.Range = Range(10, 8, 6, 4)

	(1 to 5) flatMap (x => (2 to 6) map (y => (x, y)))
                                                  //> res10: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,2), (1,
                                                  //| 3), (1,4), (1,5), (1,6), (2,2), (2,3), (2,4), (2,5), (2,6), (3,2), (3,3), (3
                                                  //| ,4), (3,5), (3,6), (4,2), (4,3), (4,4), (4,5), (4,6), (5,2), (5,3), (5,4), (
                                                  //| 5,5), (5,6))
                                
	def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
		// pattern matching function value for the map:
		(xs zip ys).map{ case (x, y) => x * y }.sum
                                                  //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double

	scalarProduct(Vector(2, 3, 1), Vector(1, 2, 1))
                                                  //> res11: Double = 9.0

	def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean

	isPrime(2)                                //> res12: Boolean = true
	isPrime(3)                                //> res13: Boolean = true
	isPrime(4)                                //> res14: Boolean = false
	isPrime(5)                                //> res15: Boolean = true
	isPrime(10)                               //> res16: Boolean = false
	isPrime(11)                               //> res17: Boolean = true
}
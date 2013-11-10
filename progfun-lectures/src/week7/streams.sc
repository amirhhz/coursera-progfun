package week7

object streams {

  def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean

  ((1000 to 10000) filter isPrime)(1)             //> res0: Int = 1013
  ((1000 to 10000).toStream filter isPrime)(1)    //> res1: Int = 1013

  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    print(lo + " ")
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi))
  }                                               //> streamRange: (lo: Int, hi: Int)Stream[Int]

	streamRange(1, 10).take(3).toList         //> 1 2 3 res2: List[Int] = List(1, 2, 3)

}
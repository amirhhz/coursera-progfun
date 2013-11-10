package week7

object sqrtstream {
	def sqrtStream(x: Double): Stream[Double] = {
		def improve(guess: Double) = (guess + x / guess) / 2
		lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
		guesses
	}                                         //> sqrtStream: (x: Double)Stream[Double]

	sqrtStream(4).take(10).toList             //> res0: List[Double] = List(1.0, 2.5, 2.05, 2.000609756097561, 2.0000000929222
                                                  //| 947, 2.000000000000002, 2.0, 2.0, 2.0, 2.0)

	def isGoodEnough(guess: Double, x: Double) =
		math.abs((guess * guess - x) / x) < 0.0001
                                                  //> isGoodEnough: (guess: Double, x: Double)Boolean

	(sqrtStream(4) filter (isGoodEnough(_, 4))).take(10).toList
                                                  //> res1: List[Double] = List(2.0000000929222947, 2.000000000000002, 2.0, 2.0, 2
                                                  //| .0, 2.0, 2.0, 2.0, 2.0, 2.0)
}
package week5

object mergesort {

	def msort(xs: List[Int]): List[Int] = {
		val n = xs.length / 2
		if (n == 0) xs
		else {
			val (first, second) = xs splitAt n
			merge(msort(first), msort(second))
		}
	}                                         //> msort: (xs: List[Int])List[Int]
	
	
	def merge(xs: List[Int], ys: List[Int]): List[Int] =
		xs match {
			case Nil => ys
			case x :: xs1 =>
				ys match {
					case Nil => xs
					case y :: ys1 =>
						if (x < y) x :: merge(xs1, ys)
						else y :: merge(xs, ys1)
				}
		}                                 //> merge: (xs: List[Int], ys: List[Int])List[Int]

	msort(List(4, 10, 2, 40, 0, -1, 3))       //> res0: List[Int] = List(-1, 0, 2, 3, 4, 10, 40)

}
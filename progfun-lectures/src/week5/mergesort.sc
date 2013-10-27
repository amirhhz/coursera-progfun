package week5

object mergesort {

	def msort(xs: List[Int]): List[Int] = {
		val n = xs.length / 2
		if (n == 0) xs
		else {
			def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
				case (Nil, _) => ys
				case (_, Nil) => xs
				case (x :: xs1, y :: ys1) =>
					if (x < y) x :: merge(xs1, ys)
					else y :: merge(xs, ys1)
			}
			val (first, second) = xs splitAt n
			merge(msort(first), msort(second))
		}
	}                                         //> msort: (xs: List[Int])List[Int]
	
	
	
	msort(List())                             //> res0: List[Int] = List()
	msort(List(3))                            //> res1: List[Int] = List(3)
	msort(List(4, 10, 2, 40, 0, -1, 3))       //> res2: List[Int] = List(-1, 0, 2, 3, 4, 10, 40)

}
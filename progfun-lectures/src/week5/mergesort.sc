package week5

object mergesort {

	def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
		val n = xs.length / 2
		if (n == 0) xs
		else {
			def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
				case (Nil, _) => ys
				case (_, Nil) => xs
				case (x :: xs1, y :: ys1) =>
					if (lt(x,y)) x :: merge(xs1, ys)
					else y :: merge(xs, ys1)
			}
			val (first, second) = xs splitAt n
			merge(msort(first)(lt), msort(second)(lt))
		}
	}                                         //> msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]
	
	def intLt(x: Int, y: Int) = x < y         //> intLt: (x: Int, y: Int)Boolean
	msort(List())(intLt)                      //> res0: List[Nothing] = List()
	msort(List(3))(intLt)                     //> res1: List[Int] = List(3)
	msort(List(4, 10, 2, 40, 0, -1, 3))(intLt)//> res2: List[Int] = List(-1, 0, 2, 3, 4, 10, 40)

	val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
  // Note the lack of types on x and y, which are inferred:
	msort(fruits)((x, y) => x.compareTo(y) < 0)
                                                  //> res3: List[String] = List(apple, banana, orange, pineapple)
}
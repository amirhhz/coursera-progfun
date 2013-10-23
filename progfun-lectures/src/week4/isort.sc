package week4

object isort {

	def isort(xs: List[Int]): List[Int] = xs match {
		case List() => List()
		case y :: ys => insert(y, isort(ys))
	}                                         //> isort: (xs: List[Int])List[Int]
	
	def insert(x: Int, xs: List[Int]): List[Int] = xs match {
		case List() => List(x)
		case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
	}                                         //> insert: (x: Int, xs: List[Int])List[Int]

		
	isort(List(3, 4, 0, 10, 1, 2))            //> res0: List[Int] = List(0, 1, 2, 3, 4, 10)

}
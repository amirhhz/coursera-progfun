package week5

object listfun {

	def squareListNaive(xs: List[Int]): List[Int] = xs match {
		case Nil => Nil
		case y :: ys => y * y :: squareListNaive(ys)
	}                                         //> squareListNaive: (xs: List[Int])List[Int]
	
	squareListNaive(List(1, 2, 3, 4, 5))      //> res0: List[Int] = List(1, 4, 9, 16, 25)

	def squareList(xs: List[Int]): List[Int] = xs map (x => x * x)
                                                  //> squareList: (xs: List[Int])List[Int]
	squareList(List(1, 2, 3, 4, 5))           //> res1: List[Int] = List(1, 4, 9, 16, 25)


	// Built-ins:
	val nums = List(2, 11, -4, 0, 1, 4, 10, 3)//> nums  : List[Int] = List(2, 11, -4, 0, 1, 4, 10, 3)
	val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
	nums filter (x => x > 0)                  //> res2: List[Int] = List(2, 11, 1, 4, 10, 3)
	nums filterNot (x => x > 0)               //> res3: List[Int] = List(-4, 0)
	nums partition (x => x > 0)               //> res4: (List[Int], List[Int]) = (List(2, 11, 1, 4, 10, 3),List(-4, 0))

	nums takeWhile (x => x > 0)               //> res5: List[Int] = List(2, 11)
	nums dropWhile (x => x > 0)               //> res6: List[Int] = List(-4, 0, 1, 4, 10, 3)
	nums span (x => x > 0)                    //> res7: (List[Int], List[Int]) = (List(2, 11),List(-4, 0, 1, 4, 10, 3))


	val data = List("a", "a", "a", "a", "b", "c", "c", "a")
                                                  //> data  : List[String] = List(a, a, a, a, b, c, c, a)
	def pack[T](xs: List[T]): List[List[T]] = xs match {
		case Nil => Nil
		case x :: xs1 =>
			val (first, second) = xs span (y => y == x)
			first :: pack(second)
	}                                         //> pack: [T](xs: List[T])List[List[T]]

	pack(data)                                //> res8: List[List[String]] = List(List(a, a, a, a), List(b), List(c, c), List(
                                                  //| a))

	// Run-length encoding:
	def encode[T](xs: List[T]): List[(T, Int)] = pack(xs) map (ys => (ys.head, ys.length))
                                                  //> encode: [T](xs: List[T])List[(T, Int)]
	encode(data)                              //> res9: List[(String, Int)] = List((a,4), (b,1), (c,2), (a,1))


	def concat[T](xs: List[T], ys: List[T]): List[T] =
		(xs foldRight ys)(_ :: _)         //> concat: [T](xs: List[T], ys: List[T])List[T]


	def mapFun[T, U](xs: List[T], f: T => U): List[U] =
		(xs foldRight List[U]())(f(_) :: _)
                                                  //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

	mapFun[Int, Int](nums, (x => x * x))      //> res10: List[Int] = List(4, 121, 16, 0, 1, 16, 100, 9)


	def lengthFun[T](xs: List[T]): Int =
		(xs foldRight 0)((_, acc) => acc + 1)
                                                  //> lengthFun: [T](xs: List[T])Int
	lengthFun(nums)                           //> res11: Int = 8
}
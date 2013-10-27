package week5

object listops {
	val l1 = List(1, 2, 3)                    //> l1  : List[Int] = List(1, 2, 3)
	val l2 = List(4, 5, 6)                    //> l2  : List[Int] = List(4, 5, 6)
	
	def last[T](xs: List[T]): T = xs match {
		case List() => throw new Error("list is empty")
		case List(x) => x
		case y :: ys => last(ys)
	}                                         //> last: [T](xs: List[T])T
	
	last(l1)                                  //> res0: Int = 3


	def init[T](xs: List[T]): List[T] = xs match {
		case List() => throw new Error("list is empty")
		case List(x) => List()
		case y :: ys => y :: init(ys)
	}                                         //> init: [T](xs: List[T])List[T]

	init(l1)                                  //> res1: List[Int] = List(1, 2)


	def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
		case List() => ys
		case z :: zs => z :: concat(zs, ys)
	}                                         //> concat: [T](xs: List[T], ys: List[T])List[T]
	
	concat(l1, l2)                            //> res2: List[Int] = List(1, 2, 3, 4, 5, 6)
	
	// This is n^2 complexity ...
	def reverse[T](xs: List[T]): List[T] = xs match {
		case List() => xs
		case y :: ys => reverse(ys) ++ List(y)
	}                                         //> reverse: [T](xs: List[T])List[T]
	
	reverse(l1)                               //> res3: List[Int] = List(3, 2, 1)
	
	def removeAt[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n + 1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]
	removeAt(1, l1)                           //> res4: List[Int] = List(1, 3)
	

	def flatten(xs: List[Any]): List[Any] = xs match {
		case List() => xs
		case Nil :: xs => flatten(xs)
		case (y :: ys) :: zs => flatten(y :: ys) ::: flatten(zs)
		case y :: ys => y :: flatten(ys)
	}                                         //> flatten: (xs: List[Any])List[Any]

	flatten(List(List(1, 1), 2, List(3, List(5, 8))))
                                                  //> res5: List[Any] = List(1, 1, 2, 3, 5, 8)
	flatten(List(List(Nil, List(1, 2, 3)), 4, 5, 6))
                                                  //> res6: List[Any] = List(1, 2, 3, 4, 5, 6)
	flatten(List(Nil, List(1, 2, 3), Nil, List(4, 5, 6)))
                                                  //> res7: List[Any] = List(1, 2, 3, 4, 5, 6)

	// Doesn't use ':::' ...
  def flatten2(xs: List[Any]): List[Any] = {
    def helper(ys: Any, acc: List[Any]): List[Any] = ys match {
      case Nil => acc
      case y :: yz => helper(y, helper(yz, acc))
      case _ => ys :: acc
    }
    helper(xs, List())
  }                                               //> flatten2: (xs: List[Any])List[Any]

	flatten2(List(List(1, 1), 2, List(3, List(5, 8))))
                                                  //> res8: List[Any] = List(1, 1, 2, 3, 5, 8)
	flatten2(List(List(Nil, List(1, 2, 3)), 4, 5, 6))
                                                  //> res9: List[Any] = List(1, 2, 3, 4, 5, 6)
	flatten2(List(Nil, List(1, 2, 3), Nil, List(4, 5, 6)))
                                                  //> res10: List[Any] = List(1, 2, 3, 4, 5, 6)

}
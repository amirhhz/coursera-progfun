package week1

object exercise {

	def fact(n: Int): Int =
		if (n == 0) 1
		else n * fact(n - 1)              //> fact: (n: Int)Int

	def factorial(n: Int): Int = {
		def loop(acc: Int, n: Int): Int =
			if (n == 0) acc
			else loop(acc * n, n - 1)
		loop(1, n)
	}                                         //> factorial: (n: Int)Int
	
	fact(8)                                   //> res0: Int = 40320
	factorial(8)                              //> res1: Int = 40320
	fact(31)                                  //> res2: Int = 738197504
	factorial(31)                             //> res3: Int = 738197504
}
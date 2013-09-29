package week2

object currying {

	// linear recursive factorial
  def lin_fact(n: Int): Int =
  	if (n == 0) 1 else n * lin_fact(n - 1)    //> lin_fact: (n: Int)Int

	lin_fact(5)                               //> res0: Int = 120

	// Currying without syntactic sugar
  def sum_ugly(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }                                               //> sum_ugly: (f: Int => Int)(Int, Int) => Int

  sum_ugly(x => x * x * x)(1, 3)                  //> res1: Int = 36
  sum_ugly(lin_fact)(1, 3)                        //> res2: Int = 9
  
	// Currying with the sugar
	def sum(f: Int => Int)(a: Int, b: Int): Int =
		if (a > b) 0
		else f(a) + sum(f)(a + 1, b)      //> sum: (f: Int => Int)(a: Int, b: Int)Int

	sum(x => x * x * x)(1, 3)                 //> res3: Int = 36
	sum(lin_fact)(1, 3)                       //> res4: Int = 9
	
	
	def product(f: Int => Int)(a: Int, b: Int): Int =
		if (a > b) 1
		else f(a) * product(f)(a + 1, b)  //> product: (f: Int => Int)(a: Int, b: Int)Int
	product(x => x)(1, 3)                     //> res5: Int = 6
	product(x => x * x * x)(1, 3)             //> res6: Int = 216
	
	// Define factorial in terms of the product of the identity of 1 to n
	def factorial(n: Int) = product(x => x)(1, n)
                                                  //> factorial: (n: Int)Int

	factorial(4)                              //> res7: Int = 24
	factorial(5)                              //> res8: Int = 120

	// Can generalise both sum and product as mapReduce operations
	def mapReduce(combiner: (Int, Int) => Int, base: Int)(mapper: Int => Int)(a: Int, b: Int): Int =
		if (a > b) base
		else combiner(mapper(a),	mapReduce(combiner, base)(mapper)(a + 1, b))
                                                  //> mapReduce: (combiner: (Int, Int) => Int, base: Int)(mapper: Int => Int)(a: 
                                                  //| Int, b: Int)Int
	// sum of numbers
	mapReduce((x, y) => x + y, 0)(x => x)(1, 3)
                                                  //> res9: Int = 6
	// sum of cubes
	mapReduce((x, y) => x + y, 0)(x => x * x * x)(1, 3)
                                                  //> res10: Int = 36
	// factorial of 5
	mapReduce((x, y) => x * y, 1)(x => x)(1, 5)
                                                  //> res11: Int = 120

	def mrProduct(f:Int => Int)(a: Int, b: Int): Int = mapReduce((x, y) => x * y, 1)(f)(a, b)
                                                  //> mrProduct: (f: Int => Int)(a: Int, b: Int)Int
	mrProduct(x => x)(1, 3)                   //> res12: Int = 6
}
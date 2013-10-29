package week6

object nqueens {
	def queens(n: Int): Set[List[Int]] = {
		
		def placeQueens(k: Int): Set[List[Int]] =
			if (k == 0) Set(List()) // nothing to do for no queens
			else
				for {
					queens <- placeQueens(k - 1)
					col <- 0 until n
					if isSafe(col, queens)
				} yield col :: queens
		placeQueens(n)
	}                                         //> queens: (n: Int)Set[List[Int]]

	def isSafe(col: Int, queens: List[Int]): Boolean = {
		// queens' indices represent rows in reverse order, and the
		// values at each index is the column filled in for that row
		val row = queens.length
		val queensWithRow = (row - 1 to 0 by -1) zip queens
		queensWithRow forall {
			// not in the same column and ...
			// not in diagonal: horizontal and vertical distance not equal
			case (r, c) => col != c && math.abs(col - c) != row - r
		}
	}                                         //> isSafe: (col: Int, queens: List[Int])Boolean
		
	def show(queens: List[Int]) = {
		val lines =
			for (col <- queens.reverse)
			yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
		"\n" + (lines mkString "\n")
	}                                         //> show: (queens: List[Int])String

	(queens(5) take 3 map show) mkString "\n" //> res0: String = "
                                                  //| * * X * * 
                                                  //| * * * * X 
                                                  //| * X * * * 
                                                  //| * * * X * 
                                                  //| X * * * * 
                                                  //| 
                                                  //| * * * * X 
                                                  //| * X * * * 
                                                  //| * * * X * 
                                                  //| X * * * * 
                                                  //| * * X * * 
                                                  //| 
                                                  //| * * * X * 
                                                  //| * X * * * 
                                                  //| * * * * X 
                                                  //| * * X * * 
                                                  //| X * * * * "
	

}
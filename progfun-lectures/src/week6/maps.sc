package week6

object maps {
	val roman = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> roman  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -> 5, X -
                                                  //| > 10)
	val capitals = Map("US" -> "Washington", "Switzerland" -> "Zurich")
                                                  //> capitals  : scala.collection.immutable.Map[String,String] = Map(US -> Washin
                                                  //| gton, Switzerland -> Zurich)
	capitals("US")                            //> res0: String = Washington
	capitals get "Andorra"                    //> res1: Option[String] = None
	capitals get "US"                         //> res2: Option[String] = Some(Washington)

	def showCapital(country: String) = capitals.get(country) match {
		case Some(capital) => capital
		case None => "missing data"
	}                                         //> showCapital: (country: String)String

	showCapital("US")                         //> res3: String = Washington
	showCapital("Andorra")                    //> res4: String = missing data

	val fruits = List("apple", "avocado", "pear", "orange", "pineapple")
                                                  //> fruits  : List[String] = List(apple, avocado, pear, orange, pineapple)
	fruits sortWith (_.length < _.length)     //> res5: List[String] = List(pear, apple, orange, avocado, pineapple)
	fruits sorted                             //> res6: List[String] = List(apple, avocado, orange, pear, pineapple)

	fruits groupBy (_.head)                   //> res7: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple, avocado), o -> List(orange))
}
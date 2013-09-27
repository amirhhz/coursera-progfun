package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c > r) 0
    else if (c == 0) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def balanceInner(chars: List[Char], openStack: String): Boolean =
      if (chars.isEmpty) (openStack == "")
      else if (chars.head == '(') balanceInner(chars.tail, chars.head + openStack)
      else if (chars.head == ')') (openStack != "" && balanceInner(chars.tail, openStack.tail))
      else balanceInner(chars.tail, openStack)

    balanceInner(chars, "")
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if (money == 0) 1
    else if (money < 0) 0
    else if (coins.isEmpty) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)

}

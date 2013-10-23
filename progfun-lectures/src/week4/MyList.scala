package week4

trait MyList[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: MyList[T]
}

class Cons[T](val head: T, val tail: MyList[T]) extends MyList[T] {
  def isEmpty = false
}

object Nil extends MyList[Nothing] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object ListExercise {
  // List(1, 2) = List.apply(1, 2)
  def apply[T](x1: T, x2: T): MyList[T] = new Cons(x1, new Cons(x2, Nil))
  def apply[T](x1: T): MyList[T] = new Cons(x1, Nil)
  def apply[T](): MyList[T] = Nil
  
  val x: MyList[String] = Nil
  
}
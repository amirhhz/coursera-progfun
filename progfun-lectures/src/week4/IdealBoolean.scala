package week4

abstract class IdealBoolean {
  
  def ifThenElse[T](t: => T, e: => T): T
  
  def && (x: => IdealBoolean): IdealBoolean = ifThenElse(x, IdealFalse)
  def || (x: => IdealBoolean): IdealBoolean = ifThenElse(IdealTrue, x)
  def unary_! : IdealBoolean = ifThenElse(IdealFalse, IdealTrue)
  
  def == (x: => IdealBoolean): IdealBoolean = ifThenElse(x, x.unary_!)
  def != (x: => IdealBoolean): IdealBoolean = ifThenElse(x.unary_!, x)

  // Assume false < true
  def < (x: => IdealBoolean): IdealBoolean = ifThenElse(IdealFalse, x)
}

object IdealTrue extends IdealBoolean {
  def ifThenElse[T](t: => T, e: => T): T = t
}

object IdealFalse extends IdealBoolean {
  def ifThenElse[T](t: => T, e: => T): T = e
}
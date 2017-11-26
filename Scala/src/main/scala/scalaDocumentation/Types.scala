package main.scala.scalaDocumentation

object Types {
  
  /**
   * Good reference : https://sanaulla.info/2009/07/12/nothingness-2/
   */
  /**
   * AnyVal and AnyRef extends Any
   * AnyVal is extended by Classes containing Values
   * AnyRef is extended by Classes holding references i.e. Object, List, Option, Classes
   * 
   * (Null, null)
   * Null is a Trait. It is a subtype of all reference classes. null is its only instance.
   * 
   * (Nothing)
   * Nothing is a trait. It is a called bottom-type because it is subclass of everything.
   * But superclass of no class because it cannot be instantiated.
   * 
   * (Nil)
   * Nil represents list that has no content. End of the list is represented as Nil. It does NOT refer to nothing.
   * 
   * (Some, None, Option)
   * Option has two subclasses None or Some.
   * None is just another sensible return value instead of null. This is to avoid npe. It signifies method has no return value.
   * Some(<Type>) as a return value is used to it separate None.
   * 
   * (Unit)
   * Type of method that doesn’t return a value of any sort. Void in java.
   */
  
  def divide(divident:Float, divisor:Float) : Option[Float] = {
    if(divisor == 0) 
      None
    else {
      Some(divident/divisor);
    }
  }
  
  def main(args:Array[String]) = {
    val divident : Float = 8;
    val divisor : Float = 0;
    val quotient = divide(divident, divisor);
    quotient match {
      case Some(i) => println(f"Quotient is : $i%.2f");
      case None => println("Cannot divide");
    }
  }
  
}
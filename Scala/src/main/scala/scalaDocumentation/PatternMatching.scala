package main.scala.scalaDocumentation

object PatternMatching extends App {
  
  def matchValue(x : Any) = {
    x match {
      case x : Int => println("Integer is passed");
      case x : String => println("String is passed");
      case other => println("No Match");
    }
  }
  
  def containsScala(x: String): Boolean = {
    val z: Seq[Char] = x
    z match {
      case Seq('s','c','a','l','a', rest @ _*) =>
        println("Rest is " + rest)
        true
      case Seq(rest @ _*) =>
        println("All is Rest "+ rest)
        false
    }
  }
  
  val v : Float = 3.14F;
  matchValue(v);
  
  val str1 = "scalaProgramming";
  val str2 = "javaProgramming";
  containsScala(str1);
  containsScala(str2);
  
}
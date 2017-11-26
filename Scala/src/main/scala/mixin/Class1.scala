package main.scala.mixin

class Class1 extends AbstractClass2 with Trait2 {
  
  def class1Method1(x : Integer) = {
    println(s"class1Method1 : ${x}");
  }
  
  val v = (x : Int) => {println("hello")};
    
}

object Main1 extends App {
  
  val obj = new Class1;
  obj.trait2Method1(2)
  
}
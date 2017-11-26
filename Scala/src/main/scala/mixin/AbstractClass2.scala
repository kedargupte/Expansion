package main.scala.mixin

abstract class AbstractClass2 extends AbstractClass {
  
  def abstractClass2Method1(x : Integer) = {
    println(s"abstractClass2Method1 : ${x}");
  }
  
  override def methodInAbstract(x : Integer) = {
    println(s"methodInAbstract In AbstractClass2 : ${x}");
  }
  
}
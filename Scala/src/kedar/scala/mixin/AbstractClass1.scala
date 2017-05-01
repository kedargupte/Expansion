package kedar.scala.mixin

abstract class AbstractClass1 extends AbstractClass {
  
  def abstractClass1Method1(x : Integer) = {
    println(s"abstractClass1Method1 : ${x}");
  }
  
  override def methodInAbstract(x : Integer) = {
    println(s"methodInAbstract In AbstractClass1 : ${x}");
  }
  
  def methodInTrait() = {
    println("methodInTrait in AbstractClass1");
  }
  
}
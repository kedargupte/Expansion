package kedar.scala.mixin

trait Trait1 extends Trait {
  
  def trait1Method1(x : Integer) = {
    println(s"trait11Method1 : ${x}");
  }
  
  override def methodInTrait() = {
    println("methodInTrait in Trait1");
  }
  
}
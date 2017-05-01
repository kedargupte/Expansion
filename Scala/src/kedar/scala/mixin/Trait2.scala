package kedar.scala.mixin

trait Trait2 extends Trait {
  
  def trait2Method1(x : Integer) = {
    println(s"trait2Method1 : ${x}");
  }
    
  override def methodInTrait() = {
    println("methodInTrait in Trait2");
  }
  
}
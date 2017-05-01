package kedar.scala.mixin

class Class2 extends AbstractClass1 with Trait2 with Trait1 {
  
  override def methodInTrait() { 
    println("methodInTrait in Class2");
    super.methodInTrait();
  }
}

object Main2 extends App {
  
  val obj = new Class2;
  obj.methodInTrait
  
}
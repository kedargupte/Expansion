package main.scala.scalaDocumentation

class Point {
  private var _x = 0
  private var _y = 0
  private val bound = 100
  def x = _x
  def x_= (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }
  def y = _y
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }
  private def printWarning = println("WARNING: Out of bounds")
}

class PointConstructor(var x : Integer, var y : Integer) {}

object SimplePoint extends App {
  val p = new Point();
    p.x = 5;
    p.y = 10;
    println(s"(${p.x}, ${p.y})");
    p.x_=(15);
    p.y_=(125);
    println(s"(${p.x}, ${p.y})");
    
    val p1 = new PointConstructor(2,4);
    println(s"(${p1.x}, ${p1.y})");
    p1.x = 6;
    p1.y = 8;
    println(s"(${p1.x}, ${p1.y})");
}
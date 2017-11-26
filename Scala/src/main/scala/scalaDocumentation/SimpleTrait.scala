package main.scala.scalaDocumentation

class PointExtended(xc: Int, yc: Int) extends Similarity {
  var x: Int = xc
  var y: Int = yc
  def isSimilar(obj: Any) =
    obj.isInstanceOf[Point] && obj.asInstanceOf[Point].x == x
}

object SimpleTrait extends App {
  val p1 = new PointExtended(2, 3)
  val p2 = new PointExtended(2, 4)
  val p3 = new PointExtended(3, 3)
  val p4 = new PointExtended(2, 3)
  println(p1.isSimilar(p2))
  println(p1.isSimilar(p3))
  // Point's isNotSimilar is defined in Similarity
  println(p1.isNotSimilar(2))
  println(p1.isNotSimilar(p4))
}

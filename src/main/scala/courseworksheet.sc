import scala.collection.immutable.List
import scala.runtime.Nothing$

//Basic Pattern Matching 2 - alternative solution
def swapIntegerPairs(pairs: Any) : Any = {
  pairs match {
    case List(x,y) => List(y, x)
    case Array(x,y) => Array(y,x)
    case Tuple2(x,y) => Tuple2(y,x)
    case _ => pairs
  }
}

swapIntegerPairs(List(1,2))
swapIntegerPairs(Array(2, 3))
swapIntegerPairs(Tuple2(4, 5))

//Basic Pattern Matching - Additional - Collection with first 2 elements
def reduceToTwoElements(coll: Traversable[Any]) : Traversable[Any] = {
  //This technically answers the question but doesn't use pattern matching!
  if (coll.size > 2)
    coll.take(2)
  else
    coll
}
reduceToTwoElements(List("A", "B", "C", "D", "E"))
reduceToTwoElements(Array("A", "B"))
reduceToTwoElements(Vector("X"))
reduceToTwoElements(Set.empty)

def reduceToTwoElementsPatternMatching(coll: Any) : Any = {
  coll match {
    case List(x, y, _*) => List(x, y)
    case Array(x, y, _*) => Array(x, y)
    case (x, y, z) => (x, y)
    case (x, y, z, a) => (x, y)
    case (x, y, z, a, b) => (x, y)
    case (x, y, z, a, b, c) => (x, y)
    case (x, y, z, a, b, c, d) => (x, y)
    case (x, y, z, a, b, c, d, e) => (x, y)
    case (x, y, z, a, b, c, d, e, f) => (x, y)
    case (x, y, z, a, b, c, d, e, f, g) => (x, y)
    case (x, y, z, a, b, c, d, e, f, g, h) => (x, y)
    case (x, y, z, a, b, c, d, e, f, g, h, i) => (x, y)
      //etc up to 22 elements!
    case _ => coll
  }

}
reduceToTwoElementsPatternMatching(List("A", "B", "C", "D", "E"))
reduceToTwoElementsPatternMatching(Array("A", "B", "C"))
reduceToTwoElementsPatternMatching("A", "B", "C")
reduceToTwoElementsPatternMatching("A", "B", "C", "D", "D")
reduceToTwoElementsPatternMatching(List("A"))

//Playing with collections - some additional problems

//Find the last element of a list

def lastUsingListLast(list : List[Any]) : Any = {
  if (! list.isEmpty)  {
    list.last
  }


}
lastUsingListLast(List("x", "y", "n"))
lastUsingListLast(List.empty)

def lastUsingListIndex(list : List[Any]) : Any = {
   list.size match {
    case 0 => null
    case _ => list(list.size - 1)
  }
}
lastUsingListIndex(List("x", "y", "v"))
lastUsingListLast(List.empty)


//------------------------------------
//Basic - Functional
java.util.TimeZone.getAvailableIDs()
val timezone = "Pacific/Samoa"
timezone.split('/')(1)
//val ids =  java.util.TimeZone.getAvailableIDs().filter(value => value.contains("/")).map(value => value.split('/')(1))

val ids2 =  java.util.TimeZone.getAvailableIDs().map(value => value.split('/')).filter(_.length > 1).map(a => a.last).grouped(10).map(a => a(0)).toArray



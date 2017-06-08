import scala.runtime.Nothing$
import scala.collection.immutable.List;

/**
  * Created by Administrator on 05/06/2017.
  */
object Main {


  def main(args: Array[String]) = {
    //Basic - Hello World
    println("Hello World!")

    println("Basic - Assignment")
    val hw = "Hello World!"
    println(hw)

    println("Basic - Parameters")
    printString("Hello World 3!")

    println("Basic - Return types")
    println(retString)

    println("Basic - Type inference")
    println(inferType(12.23))
    println(inferType("I am a String"))
    println(inferType(22))
    println(inferType(true))

    println("Basic - Strings 1")
    println(getEndOfString("Hello", 3))
    println(getEndOfString("Hello", 5))
    println(getEndOfString("Hello", 0))
    println(getEndOfString("Hello", 6))

    println("Basic - Strings 2")
    println(getMergedString("Ha", "llo", 'a', 'e'))

    println("Basic - Operators")
    println(getIntSum(1, 2))

    println("Basic - Conditionals 1")
    println(getIntSumOrProduct(3, 5, true))
    println(getIntSumOrProduct(3, 5, false))

    println("Basic - Conditionals 1 - Pattern Matching")
    println(getIntSumOrProductPattern(3, 5, true))
    println(getIntSumOrProductPattern(3, 5, false))

    println("Basic - Conditionals 2")
    println(getIntSumOrProductOrNonZero(3, 5, true))
    println(getIntSumOrProductOrNonZero(3, 5, false))
    println(getIntSumOrProductOrNonZero(0, 5, true))
    println(getIntSumOrProductOrNonZero(0, 5, false))
    println(getIntSumOrProductOrNonZero(3, 0, true))
    println(getIntSumOrProductOrNonZero(3, 0, false))
    println(getIntSumOrProductOrNonZero(0, 0, true))
    println(getIntSumOrProductOrNonZero(0, 0, false))

    println("Basic - Conditionals 2 - Pattern Matching")
    println(getIntSumOrProductOrNonZeroPattern(3, 5, true))
    println(getIntSumOrProductOrNonZeroPattern(3, 5, false))
    println(getIntSumOrProductOrNonZeroPattern(0, 5, true))
    println(getIntSumOrProductOrNonZeroPattern(0, 5, false))
    println(getIntSumOrProductOrNonZeroPattern(3, 0, true))
    println(getIntSumOrProductOrNonZeroPattern(3, 0, false))
    println(getIntSumOrProductOrNonZeroPattern(0, 0, true))
    println(getIntSumOrProductOrNonZeroPattern(0, 0, false))

    println("Basic - Iteration 1")
    printStringIterative("Hi", 3)

    println("Basic - Iteration 2")
    printRectangularString("H", 4)
    printRectangularString("Hello", 6)

    println("Basic - Iteration 3 - FizzBuzz")
    doFizzBuzz("Fizz", "Buzz", 15)
    println()

    println("Basic - Iteration 4 - Recursion")

    printStringRecursive("Hi", 3)
    printStringRecursive("Chris", 1)
    printStringRecursive("Chris", 0)

    printRectangularStringRecursive("H", 4, 4)

    doFizzBuzzRecursive("Fizz", "Buzz",1, 15)
    println()

    println("Basic - Pattern matching 2")
    val list : List[Int] = List(1,2)
    println(swapIntegerPairs(list))

    val array : Array[Int] = Array(2, 3)
    swapIntegerPairs(array) match {
      case array: Array[Int] => for (i <- array) print(s"$i ," )
    }
    println()

    val tuple : Tuple2[Int, Int] = Tuple2(4, 5)
    println(swapIntegerPairs(tuple))

  }
  //Basic - Parameters
  def printString(str: String) : Unit = {
    println(str);
  }

  //Basic - Return types
  def retString() : String = {
    "Hello World"
  }

  //Basic - Type inference
  def inferType(arg: Any) : Any = {
    arg
  }

  //Basic - Strings 1
  def getEndOfString(str: String, noOfChars: Int) : String = {
    if (noOfChars <= str.length) {
      str.substring(str.length - noOfChars, str.length)
    }
    else "Invalid input"
  }

  //Basic - Strings 2
  def getMergedString(str1: String, str2: String, oldChar : Char, newChar: Char) : String = {
    str1.concat(str2).replace(oldChar, newChar)
  }

  //Basic - Operators
  def getIntSum(int1: Int, int2: Int) : Int = {
    int1 + int2
  }

  //Basic - Conditionals 1
  def getIntSumOrProduct(int1: Int, int2: Int, isAdd: Boolean) : Int = {
    if (isAdd)
      int1 + int2
    else
      int1 * int2
  }

  //Basic - Conditionals 2
  def getIntSumOrProductOrNonZero(int1: Int, int2: Int, isAdd: Boolean) : Int = {
    if (int1 == 0 && int2 != 0)
      int2
    else if (int2 == 0 && int1 != 0)
      int1
    else if (isAdd)
      int1 + int2
    else
      int1 * int2
  }

  //Basic - Iteration 1
  def printStringIterative(str: String, noOfTimes : Int) : Unit = {
    for (i <- 1 to noOfTimes)
      println(str);
  }

  //Basic - Iteration 2
  def printRectangularString(str : String, noOfTimes: Int) : Unit = {
    for (i <- 1 to noOfTimes)
      println(str.concat(" ") * noOfTimes)
  }

  //Basic - Iteration 3
  /*
  Create a method that accepts three parameters, two strings and one integer. Your method will then loop from 1 to the integer provided, outputting the current iteration count every iteration.
However if the current iteration is divisible by 3, output the first String provided.
If the current iteration is divisible by 5, output the second String provided.
If it is divisible by both 3 and 5, then output the concatenation of the two Strings.
Input-> (Fizz,Buzz,15)
Output-> 1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz
   */
  def doFizzBuzz(str1 : String, str2: String, end: Int) : Unit = {
    for (i <- 1 to end) {
      if (i % 3 == 0 && i % 5 == 0)
        print(str1.concat(str2))
      else if (i % 3 == 0)
        print(str1)
      else if (i % 5 == 0)
        print(str2)
      else print(i)
      if (i < end) print(",")

    }
    println()
  }

  //Basic - Iteration 1 - Recursive
  def printStringRecursive(str: String, noOfTimes : Int) : Unit = {
    if (noOfTimes > 1)
       printStringRecursive(str, noOfTimes - 1)
    println(str)
  }

  //Basic - Iteration 2 - Recursive
  def printRectangularStringRecursive(str : String, noOfCols: Int, noOfLines: Int) : Unit = {
    if (noOfLines > 1 )
      printRectangularStringRecursive(str, noOfCols, noOfLines -1)
    println(str.concat(" ") * noOfCols)
  }

  //Basic - Iteration 3 - Recursive
  def doFizzBuzzRecursive(str1 : String, str2: String, current: Int, end: Int) : Unit = {

      if (current % 3 == 0 && current % 5 == 0)
        print(str1.concat(str2))
      else if (current % 3 == 0)
        print(str1)
      else if (current % 5 == 0)
        print(str2)
      else print(current)
      if (current < end) {
        print(",")
        doFizzBuzzRecursive(str1, str2, current + 1, end)
      }
    }

  //Basic - Conditionals 1 - Pattern Matching
  def getIntSumOrProductPattern(int1: Int, int2: Int, isAdd: Boolean) : Int = {
    isAdd match {
      case true => int1 + int2
      case false => int1 * int2
    }
  }

  //Basic - Conditionals 2 - Pattern Matching
  def getIntSumOrProductOrNonZeroPattern(int1: Int, int2: Int, isAdd: Boolean) : Int = {

    int1 match {
      case 0 => int2
      case _ => {
        int2 match {
          case 0 => int1
          case _ => {
            isAdd match {
              case true => int1 + int2
              case false => int1 * int2
            }
         }
        }
      }
    }
   }

  //Basic - Pattern Matching 2
  def swapIntegerPairs(pairs: Any) : Any = {
    pairs match {
      case list :List[Int] => list.reverse
      case array: Array[Int] => array.reverse
      case tuple: Tuple2[Int, Int] => tuple.swap
      case _ => pairs
    }
  }

  //Basic - Pattern Matching - Additional - Collection with first 2 elements
  def reduceToTwoElements(coll: Traversable[Any]) : Traversable[Any] = {
    coll.slice(0, 2);
  }
}


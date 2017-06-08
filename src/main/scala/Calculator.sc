/*Create a program that will take a series of numbers (5, 3, 15), and find how those numbers can add,
subtract, multiply, or divide in various ways to relate to eachother. This string of numbers should result
in 5 * 3 = 15, or 15 /3 = 5, or 15/5 = 3. When you are done, test your numbers with the following strings:

4, 2, 8

4*2=8 , 8/4=2 , 8/2=4

6, 2, 12

6, 2, 3

9, 12, 108

4, 16, 64

Step 2 have the program list all possible combinations.

Step 3, allow the program to deal with strings of greater than three numbers. For example, an input of (3, 5, 5, 3) would be 3 * 5 = 15, 15/5 = 3. When you are finished, test them with the following strings.

2, 4, 6, 3

1, 1, 2, 3

4, 4, 3, 4

8, 4, 3, 6

9, 3, 1, 7​
*/

def testMultiply (int1: Int, int2: Int, int3:Int ) : Option[String] = {
  val str = s"$int1 * $int2 = $int3"
  if(int1 * int2 == int3) Some(str) else None
}

def testDivide (int1: Int, int2: Int, int3:Int ) : Option[String] = {
  val str = s"$int1 / $int2 = $int3"
  if(int1 / int2 == int3) Some(str) else None
}

def testAdd (int1: Int, int2: Int, int3:Int ) : Option[String] = {
  val str = s"$int1 + $int2 = $int3"
  if(int1 + int2 == int3) Some(str) else None
}

def testSubtract (int1: Int, int2: Int, int3:Int ) : Option[String] = {
  val str = s"$int1 - $int2 = $int3"
  if(int1 - int2 == int3) Some(str) else None
}

def calculator(int1: Int, int2: Int, int3: Int): Array[String] = {

  var combinations = scala.collection.mutable.ArrayBuffer.empty[String]

  val paramCombs = Array((int1, int2, int3), (int2, int3, int1), (int1, int3, int2), (int2, int1, int3), (int3, int2, int1), (int3, int1, int2))
  paramCombs.map(value => testAdd(value._1, value._2, value._3) map (comb => combinations += comb) )
  paramCombs.map(value => testSubtract(value._1, value._2, value._3) map (comb => combinations += comb) )
  paramCombs.map(value => testMultiply(value._1, value._2, value._3) map (comb => combinations += comb) )
  paramCombs.map(value => testDivide(value._1, value._2, value._3) map (comb => combinations += comb) )
  combinations.toArray

}

calculator(4,2,8)
calculator(6,2,12)
calculator(6,2,3)
calculator(9,12,108)
calculator(4,16,64)

//Step 3

def numberCombs (numbers : List[Int], index : Int) : Array[(Int, Int, Int)] = {
  var combs = scala.collection.mutable.ArrayBuffer.empty[(Int, Int, Int)]

  for (i <- 1 to numbers.length) {

  }

}

def calculator2(int1: Int, int2: Int, int3: Int): Array[String] = {

  var combinations = scala.collection.mutable.ArrayBuffer.empty[String]

  val paramCombs = Array((int1, int2, int3), (int2, int3, int1), (int1, int3, int2), (int2, int1, int3), (int3, int2, int1), (int3, int1, int2))
  paramCombs.map(value => testAdd(value._1, value._2, value._3) map (comb => combinations += comb) )
  paramCombs.map(value => testSubtract(value._1, value._2, value._3) map (comb => combinations += comb) )
  paramCombs.map(value => testMultiply(value._1, value._2, value._3) map (comb => combinations += comb) )
  paramCombs.map(value => testDivide(value._1, value._2, value._3) map (comb => combinations += comb) )
  combinations.toArray

}


// Test addition
/*  testAdd(int1, int2, int3) map (comb => combinations += comb)
  testAdd(int2, int3, int1) map (comb => combinations += comb)
  testAdd(int1, int3, int2) map (comb => combinations += comb)
  testAdd(int2, int1, int3) map (comb => combinations += comb)
  testAdd(int3, int2, int1) map (comb => combinations += comb)
  testAdd(int3, int1, int2) map (comb => combinations += comb)
*/

// Test subtraction
/*  testSubtract(int1, int2, int3) map (comb => combinations += comb)
  testSubtract(int2, int3, int1) map (comb => combinations += comb)
  testSubtract(int1, int3, int2) map (comb => combinations += comb)
  testSubtract(int2, int1, int3) map (comb => combinations += comb)
  testSubtract(int3, int2, int1) map (comb => combinations += comb)
  testSubtract(int3, int1, int2) map (comb => combinations += comb)
*/

// Test Multiplication

/*  testMultiply(int1, int2, int3) map (comb => combinations += comb)
  testMultiply(int2, int3, int1) map (comb => combinations += comb)
  testMultiply(int1, int3, int2) map (comb => combinations += comb)
  testMultiply(int2, int1, int3) map (comb => combinations += comb)
  testMultiply(int3, int2, int1) map (comb => combinations += comb)
  testMultiply(int3, int1, int2) map (comb => combinations += comb)
*/
  // Test Division
/*  testDivide(int1, int2, int3) map (comb => combinations += comb)
  testDivide(int2, int3, int1) map (comb => combinations += comb)
  testDivide(int1, int3, int2) map (comb => combinations += comb)
  testDivide(int2, int1, int3) map (comb => combinations += comb)
  testDivide(int3, int2, int1) map (comb => combinations += comb)
  testDivide(int3, int1, int2) map (comb => combinations += comb)
*/



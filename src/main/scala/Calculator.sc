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



/*def calculator(int1: Int, int2: Int, int3: Int): Array[String] = {

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
*/
//Step 3

/*def indexCombs (numbers : List[Int]) : IndexedSeq[(Int, Int)] = {
  var combs = scala.collection.mutable.ArrayBuffer.empty[(Int, Int)]
  for (i <- 0 to numbers.length - 2) {
    for (j <- i + 1 until numbers.length)
      combs.append((i, j))
  }
  combs.toArray
}

indexCombs(List(1, 2, 3))
indexCombs(List(1, 2, 3, 4))
indexCombs(List(1, 2, 3, 4, 5))

def testComb(numberIndices: Tuple2[Int, Int], numList: List[Int]) : Array[String] = {
  var connections = scala.collection.mutable.ArrayBuffer.empty[String]
  (0 until numList.length).map(i =>
      if (i != numberIndices._1 && i != numberIndices._2) {
        testAdd(numList(numberIndices._1), numList(numberIndices._2), numList(i) ) map (comb => connections += comb)
        testSubtract(numList(numberIndices._1), numList(numberIndices._2), numList(i) ) map (comb => connections += comb)
        testMultiply(numList(numberIndices._1), numList(numberIndices._2), numList(i) ) map (comb => connections += comb)
        testDivide(numList(numberIndices._1), numList(numberIndices._2), numList(i) ) map (comb => connections += comb)
      }
    )
  connections.toArray
}
*/
def calculator2(intList: List[Int]): Array[String] = {
  var connections = scala.collection.mutable.ArrayBuffer.empty[String]
  val indexCombs = (0 to intList.length - 2).flatMap(i => for (j <- i +1 until intList.length) yield (i,j))
  indexCombs.map(numbersToTest =>
    (intList.indices).filter(i => i != numbersToTest._1 && i != numbersToTest._2).map(i => {
      testAdd(intList(numbersToTest._1), intList(numbersToTest._2), intList(i)) map (comb => connections += comb)
      testSubtract(intList(numbersToTest._1), intList(numbersToTest._2), intList(i)) map (comb => connections += comb)
      testMultiply(intList(numbersToTest._1), intList(numbersToTest._2), intList(i) ) map (comb => connections += comb)
      testDivide(intList(numbersToTest._1), intList(numbersToTest._2), intList(i) ) map (comb => connections += comb)
      }
    ))
  connections.toArray
}

def testMultiply (int1: Int, int2: Int, int3:Int ) : Option[String] = {
  if(int1 * int2 == int3) Some(s"$int1 * $int2 = $int3") else None
}

def testDivide (int1: Int, int2: Int, int3:Int ) : Option[String] = {
  if(int1 / int2 == int3) Some(s"$int1 / $int2 = $int3")
  else if (int2 / int1 == int3) Some(s"$int2 / $int1 = $int3")
  else None
}

def testAdd (int1: Int, int2: Int, int3:Int ) : Option[String] = {
  if(int1 + int2 == int3) Some(s"$int1 + $int2 = $int3") else None
}

def testSubtract (int1: Int, int2: Int, int3:Int ) : Option[String] = {
  if(int1 - int2 == int3) Some(s"$int1 - $int2 = $int3")
  else if (int2 - int1 == int3) Some(s"$int2 - $int1 = $int3")
  else None
}

calculator2(List(4,2,8))
calculator2(List(6,2,12))
calculator2(List(6,2,3))
calculator2(List(9,12,108))
calculator2(List(4,16,64))
calculator2(List(2, 4, 6, 3))





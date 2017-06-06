/*
Unique Sum
Given 3 integer values, return their sum. If one value is the same as another value, they do
not count towards the sum. Aka only return the sum of unique numbers given.
Input(1,2,3) -> 6
Input (3,3,3) -> 0
Input (1,1,2) -> 2

First implementation is simple but would not be extensible if variable number of parameters sent in - more elegant solution needed
 */

def uniqueSum(a: Int, b: Int, c: Int) : Int = {
  a match {
    case _ if a == b && a == c => 0
    case _ if a == b => c
    case _ if a == c => b
    case _ if b == c => a
    case _ => a + b + c
  }
}

uniqueSum(1,2,3)
uniqueSum(3,3,3)
uniqueSum(1,1,2)
uniqueSum(1,2,1)
uniqueSum(3,3,5)

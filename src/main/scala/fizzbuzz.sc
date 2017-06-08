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
}

doFizzBuzz("Fizz", "Buzz", 15)
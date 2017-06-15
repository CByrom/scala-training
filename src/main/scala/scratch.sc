val numbers = List(1, 2, 3, 4)
(0 to numbers.length - 2).flatMap(i => for (j <- (i +1 until numbers.length)) yield (i,j))
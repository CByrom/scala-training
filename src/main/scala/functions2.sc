/*
Compose and andThen
 */

def func1 (input: Int) : Int = {
  input + 3
}

def func2 (input : Int) : Int = {
  input - 2
}

def funcFirst(input: Int) : Int = {
  input * 2
}

def funcOther (input: Int) : String = {
  if (input > 10) s"$input greater than 10"
  else s"$input not greater than 10"
}

(funcFirst _ andThen func1)(3)
(funcFirst _ andThen func1 andThen func2)(3)
(func1 _ andThen func2 compose funcFirst andThen funcOther)(3)
(func1 _ andThen func2 andThen funcFirst andThen funcOther)(5)
(func1 _ andThen func2 compose funcFirst andThen funcOther)(5)
(func1 _ compose func2 andThen funcFirst andThen funcOther)(5)
(func1 _ compose func2 compose funcFirst andThen funcOther)(5)
(funcOther _ compose func1 _ compose func2 compose funcFirst)(5)
(funcOther _ compose func2 _ compose funcFirst compose func1)(5)
/*
Too hot?
Given an integer value and a Boolean value, temperature and isSummer, if temperature is
between 60 and 90 (inclusive), unless its summer where the upper limit is 100 instead of 90.
Return true if the temperature falls within the range, false otherwise.
Input(80,false) -> true
Input(100,false) -> false
Input(100,true) -> true
 */

def isTooHot(temperature: Int, isSummer: Boolean) : Boolean = {
  isSummer match {
    case true => (temperature >=60 && temperature <= 100)
    case false => (temperature >=60 && temperature <= 90)
  }
}

isTooHot(60, true)
isTooHot(60, false)
isTooHot(90, true)
isTooHot(90, false)
isTooHot(100, true)
isTooHot(100, false)
isTooHot(101, true)
isTooHot(91, false)
isTooHot(80, false)
isTooHot(80, true)
isTooHot(59, true)
isTooHot(59, false)
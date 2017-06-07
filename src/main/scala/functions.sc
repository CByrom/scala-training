//implicit variables
implicit val price = 6.50

//Optional parameters
def applyOptional(noOfItems: Int, discountRate:Option[Double]) : Double = {
  val cost = noOfItems * price
  discountRate match {
    case Some(discount) => cost * (1.0 - discount)
    case None => cost
  }
}

applyOptional(3, None)
applyOptional(3, Some(0.1))

//Now provide a default of None for the optional parameter
def applyOptionalDefault(noOfItems: Int, discountRate:Option[Double] = None) : Double = {
  val cost = noOfItems * price
  discountRate match {
    case Some(discount) => cost * (1.0 - discount)
    case None => cost
  }
}
applyOptionalDefault(3)
applyOptionalDefault(3, Some(0.1))

//Now make the return value optional so that no price is returned if discount is too high
def applyOptionalDefaultReturn(noOfItems: Int, discountRate:Option[Double] = None) : Option[Double] = {
  val cost = noOfItems * price
  discountRate match {
    case Some(discount) if discount < 1.0 => Some(cost * (1.0 - discount))
    case None => Some(cost)
    case _ => None
  }
}
applyOptionalDefaultReturn(3)
applyOptionalDefaultReturn(3, Some(0.1))
applyOptionalDefaultReturn(3, Some(1.1))

//Explore the ways around the null pointer issue..
val noPrice = applyOptionalDefaultReturn(3, Some(1.1)).getOrElse("No Price")
val noPriceAgain = applyOptionalDefaultReturn(3, Some(1.1))
val convertedPrice = noPriceAgain match {
  case Some(price) => price
  case None => 0.0
}

//Override the implicit variable
def applyImplicitOverride(noOfItems: Int, discountRate:Option[Double] = None)(implicit price : Double) : Option[Double] = {
  val cost = noOfItems * price
  discountRate match {
    case Some(discount) if discount < 1.0 => Some(cost * (1.0 - discount))
    case None => Some(cost)
    case _ => None
  }
}

applyImplicitOverride(3)
applyImplicitOverride(3)(5.0)

// Var args - can you do it with typed params rather than generics?
def sumItems(items: Int*) : Int = {
  items.sum
}
sumItems(1, 2,3 )

//Partially applied params - different combs - looks like position matters, couldn't call it using param 2 or 3 first
def applyParamsPartially(a: Int) (b:String) (c: Double) : String = s"$a $b $c"

val firstParamApplied = applyParamsPartially(1)_
firstParamApplied("Hi")(1.0)

val first2ParamsApplied = applyParamsPartially(1)("Hi")_
first2ParamsApplied(1.0)

//Anonymous functions
var anonDiscount = (noOfItems: Int, discountRate: Double) => {
    noOfItems * price * (1.0 - discountRate)
}

//Higher order functions
def calcPrice (noOfItems: Int, price: Double) = {
  noOfItems * price * (1.0 - giveDiscount(noOfItems))
}

def giveDiscount(noOfItems: Int) : Double = {
  noOfItems match {
    case _ if noOfItems < 10 => 0.1
    case _ => 0.25
  }
}

calcPrice(2, 1.5)
calcPrice(10, 1.0)
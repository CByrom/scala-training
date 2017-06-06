//Intermediate exercise - BlackJack
/*
Given 2 integer values greater than 0, return whichever value is closest to 21 without going
over 21. If they both go over 21 then return 0
Input(18,21) -> 21
Input(20,18) -> 20
Input(22,22) -> 0
 */
def blackjack(a: Int, b:Int) : Int = {
 List(a, b, 0).sorted.filter(p => p <22).last
}
blackjack(18, 21)
blackjack(20, 18)
blackjack(22, 22)
blackjack(18,18)
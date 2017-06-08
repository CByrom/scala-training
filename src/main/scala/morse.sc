def morseDecode (string: String): String = {

  val words = string.split("/")
  var outPutString : StringBuilder = new StringBuilder

for (word <- words){

  var letters = word.split(" ")

  for (letter <- letters){

    letter match {

      case ".-" => outPutString.append("A")
      case "-..." => outPutString.append("B")
      case "-.-." => outPutString.append("C")
      case "-.." => outPutString.append("D")
      case "." => outPutString.append("E")
      case "..-." => outPutString.append("F")
      case "--." => outPutString.append("G")
      case "...." => outPutString.append("H")
      case ".." => outPutString.append("I")
      case ".---" => outPutString.append("J")
      case "-.-" => outPutString.append("K")
      case ".-.." => outPutString.append("L")
      case "--" => outPutString.append("M")
      case "-." => outPutString.append("N")
      case "---" => outPutString.append("O")
      case ".--." => outPutString.append("P")
      case "--.-" => outPutString.append("Q")
      case ".-." => outPutString.append("R")
      case "..." => outPutString.append("S")
      case "-" => outPutString.append("T")
      case "..-" => outPutString.append("U")
      case "...-" => outPutString.append("V")
      case ".--" => outPutString.append("W")
      case "-..-" => outPutString.append("X")
      case "-.--" => outPutString.append("Y")
      case "--.." => outPutString.append("Z")
      case _ =>


    }


  }

  outPutString.append(" ")

}

  outPutString.toString()

}


morseDecode(".... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- . .-. / --. --- --- -.. / .-.. ..- -.-. -.- / --- -. / - .... . / -.-. .... .- .-.. .-.. . -. --. . ... / - --- -.. .- -.--")

implicit val codes = Map(".-"->'A', "-..."-> 'B', "-.-."-> 'C', "-.."-> 'D', "."-> 'E',
  "..-."-> 'F', "--."-> 'G', "...."-> 'H', ".."-> 'I', ".---"-> 'J',
  "-.-" -> 'K', ".-.."-> 'L', "--"-> 'M', "-."-> 'N', "---"-> 'O',
  ".--."-> 'P', "--.-"-> 'Q', ".-."-> 'R', "..." -> 'S', "-" -> 'T',
  "..-" -> 'U', "...-"-> 'V', ".--"-> 'W', "-..-"-> 'X', "-.--"-> 'Y',
  "--.."-> 'Z', "/" -> ' ')

def decodeMorse (morse : String) : String = {
  morse.split(" ").flatMap(letter => codes.get(letter)).mkString
}

decodeMorse(".... . .-.. .-.. --- / -.. .- .. .-.. -.-- ")
decodeMorse(".... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- . .-. / --. --- --- -.. / .-.. ..- -.-. -.- / --- -. / - .... . / -.-. .... .- .-.. .-.. . -. --. . ... / - --- -.. .- -.--")
